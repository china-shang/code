import java.util.List;
import java.util.ArrayList;

class LuoMetrix54Mid {
    // 螺旋打印
    // 使用模拟的方式,每次遇到边界或已遍历的就换向
    // right : {1, 0, -1, 0} up:{0, 1, 0, -1} (d + 1) % 4
    // row+up[d] col+right[d]
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        boolean [][] has = new boolean[matrix.length][matrix[0].length];

        int rows = matrix.length, cols= matrix[0].length, step = rows * cols, row=0,col=0,d=0;
        int[] right = new int[]{1, 0, -1, 0};
        int[] up = new int[]{0, 1, 0, -1};

        while(step-- > 0){
            has[row][col] = true;
            res.add(matrix[row][col]);
            if(row + up[d] >= rows || row + up[d] < 0 || col + right[d] >= cols || col + right[d] < 0 || has[row + up[d]][col + right[d]] == true){
                d = (d + 1) % 4;
            }
            row += up[d];
            col += right[d];
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        }));
    }
}
