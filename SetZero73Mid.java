import java.util.Set;
import java.util.HashSet;

class SetZero73Mid {
    // 不是记录下所有为0的点,而是标记某行,某列是否需要标记为0,这样不会由于0在某一行列上,导致多次变0
    // 使用数组标记而不是set
    // 最后遍历matrix而不是遍历标记数组,通过if rows[i] || cols[j] 来判断是否需要设置为0
    public static void setZeroes1(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int row: rows){
            for(int i = 0; i < n; i++){
                matrix[row][i] = 0;
            }
        }
        for(int col: cols){
            for(int i = 0; i < m; i++){
                matrix[i][col] = 0;
            }
        }

    }
    public static void main(String[] args) {
    }
}
