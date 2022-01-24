class SearchMatrix74Mid{
    // 方案一:遍历复杂度O(m*n)
    // 方案二:利用有序性,二分查找.
    // 取mid=(r - l >> 1) + l,分为3断
    // 如果target在matrix[mid][0] - matrix[mid][n-1],继续在matrix[mid]中二分查找,
    // 否则二分查找左侧或者右侧
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length==0){
            return false;
        }
        return searchMatrix(matrix, target, 0, matrix.length - 1);
    }
    public static boolean searchMatrix(int[][] matrix, int target, int l, int r) {
        if(l > r){
            return false;
        }
        int mid = ( r - l >> 1) + l;
        if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target){
            return search(matrix[mid],target,  0, matrix[mid].length - 1);
        } else if (matrix[mid][0] > target){
            return searchMatrix(matrix, target, l, mid - 1);
        }
        return searchMatrix(matrix, target, mid + 1, r);
    }
    public static boolean search(int[] arr, int target,int l, int r){
        while(l <= r){
            int mid = (r - l >> 1) + l;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] > target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                    {1, 2, 4, 9},
                    {11, 12, 14, 18},
                    {51, 52, 56},
                    {61, 62, 63, 64}
                };
        // true
        System.out.println(searchMatrix(matrix, 56));
        // false
        System.out.println(searchMatrix(matrix, 55));
    }
}
