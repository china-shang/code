class MinPathSum64Mid{
    // 从结尾往前推,根据结论推过程,既然是最小的,那第n-1步必定选的是小的,
    // n-2步也是...第2步也是.
    // 但是从头无法推到尾,因为就算下一步选小的,可能之后会遇到大的
    // 使用原数组来作为dp,因为g[i][j]只有计算dp[i][j]用到了,之后不会用到
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n; j++){
                if(i > 0 || j > 0){
                    grid[i][j] += Math.min((i > 0 ? grid[i-1][j]:Integer.MAX_VALUE), (j > 0 ? grid[i][j-1] : Integer.MAX_VALUE));
                }

            }
        }
        return grid[m-1][n-1];
    }
    public static void main(String[] args) {

    }
}
