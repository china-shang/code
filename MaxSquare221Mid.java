import java.util.Arrays;
class MaxSquare221Mid{
    // 如果matrix[i][j]=='1',设i,j是正方形的右下角,则i-1,j i,j-1 i-1,j-1是3个更小的正方形的右下角
    // 反过来.i,j为右下角构成的最大正方形长度f(i,j) = min(f(i-1,j), f(i,j-1),f(i-1,j-1)
    // 滚动数组，使用两个数组进行迭代
    // 数组复制不能dp[0]=dp[1] dp[0] = Arrays.copyOf(dp[1], dp[1].length)
    public int maximalSquare2(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        int[][] dp = new int[2][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1'){
                    dp[1][j] = Math.min(Math.min(j==0 ? 0 : dp[1][j-1], dp[0][j]), j==0 ? 0 :dp[0][j-1]) + 1;
                    max = Math.max(dp[1][j], max);
                } else {
                    dp[1][j] = 0;
                }
            }
            dp[0] = Arrays.copyOf(dp[1], dp[1].length);
        }

        return max * max;
    }

    //如果下一行，下一列都是1那么长度+1
    //第0列  0~0+0行 第0行 0~0+0列 为1
    //第1列 0~1行 第1行 0~1列 为1
    //第2列 0~2行 第2行 0~2列 为2
    //...直到不符合条件 返回i
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int t = cal(i, j, matrix);
                max = max > t ? max : t;
            }
        }

        return max * max;
    }

    public static int cal(int y, int x,char[][] matrix){
        int i = 0;
        for(i = 0;y + i < matrix.length && x + i < matrix[0].length ;i++){
            for(int j=x; j <= x + i;j++ ){
                if(matrix[y + i][j] != '1'){
                    return i;
                }
            }
            for(int j=y; j <= y + i; j++){
                if(matrix[j][x+i] != '1'){
                    return i;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
