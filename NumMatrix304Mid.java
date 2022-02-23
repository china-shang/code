class NumMatrix304Mid {
    int[][] sums;
    // 大矩形减去两个小矩形然后加上一个最小矩形
    public NumMatrix304Mid(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sums = new int[m][n];
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n; j++){
                sums[i][j] = (i > 0 ? sums[i-1][j]:0) + (j > 0?sums[i][j-1]:0) - (i > 0 && j > 0?sums[i-1][j-1]:0) + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2][col2] - (col1 > 0 ? sums[row2][col1-1] :0 ) -
            (row1 > 0 ? sums[row1-1][col2] :0) + (row1 > 0 && col1 > 0? sums[row1-1][col1-1]:0);

    }
    public static void main(String[] args) {

    }
}

