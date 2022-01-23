class UniquePaths63Mid{
    // dp[i][j] = g[i][j] == 1 ? 0 :((i > 0? dp[i-1][j] ? 0) + (j > 0 ? dp[i][j-1] : 0))
    // if g[i][j] == 1 then dp[i][j] = 0,continue else 按公式计算
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j==0){
                    dp[i][j] = 1;
                }
                if(i > 0 ){
                    dp[i][j] += dp[i-1][j];
                }
                if(j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {

    }
}
