class SearchMetrix240Mid {
    // 二分法，即每步可以排除两条路的一条
    // 从左上脚两边都是递增,如果是正方形,可以和右下角组合，根据中点确定子正方形
    // 由于不确定是正方形,从右上角开始，大了往左，小了往下
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
    public static void main(String[] args) {

    }
}
