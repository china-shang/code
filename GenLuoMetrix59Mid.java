import java.util.Arrays;
class GenLuoMetrix59Mid {
    // 模拟法 使用d表示方向, d=(d + 1) % 4,有4个方向
    // 使用两个数组代表对于方向的增量,row += up[d] col += right[d]
    // 下一步如果原方向不可行,就换向
    // 使用step表示总步数,则num = {1, n * n} num <= step则走
    public static int[][] generateMatrix(int n) {
        int[][] metrix = new int[n][n];
        int row = 0, col = 0, d=0, step=n * n, num=1;
        int[] up = new int[]{0, 1, 0, -1}, right = new int[]{1, 0, -1, 0};
        while(num <= step){
            metrix[row][col] = num++;
            if(row + up[d] >= n || row + up[d] < 0 || col + right[d] >=n || col + right[d] < 0 || metrix[row+up[d]][col+right[d]] != 0){
                d = (d + 1) % 4;
            }
            row += up[d];
            col += right[d];
        }
        return metrix;
    }
    public static void main(String[] args) {
        int[][] res = generateMatrix(10);
        for(int[] i :res ){
            System.out.println(Arrays.toString(i));
        }

    }
}
