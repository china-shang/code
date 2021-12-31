class Offer04Find2D {
    // 从左下或右上开始找，大了往小的方向走，小了往大的方向走，
    // 所以左上和右下开始遍历不行，方向只有一个
    // 有两个方向选择后，每次都可以排除一个方向 复杂度O(M+N)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        for(int i=0,j=matrix[0].length - 1; i < matrix.length && j >= 0;){
            if(matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
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

