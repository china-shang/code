class UniquePaths62Mid{
    // 动态规划f(m,n)可以走到右边的矩形,或者下面的矩形
    // 所以f(m,n) = (m>0 ? f(m-1,n) : 0) + (n>0 ? f(m,n-1):0)
    // 从0,0 -> 0,n-1 -> m-1,0 -> m-1,n-1计算出结果
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j==0){
                    dp[0][0] = 1;
                    continue;
                }
                if( i > 0){
                    dp[i][j] += dp[i-1][j];
                }
                if( j> 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        // 28
        System.out.println(uniquePaths(3, 7));

    }
}
