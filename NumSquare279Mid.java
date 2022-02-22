class NumSquare279Mid{
    // f(n)依赖与右边一堆元素即f(n) = 1 + min(f(n-1), f(n-4), f(n-9)..f(n-j*j)) j * j <= i
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int t = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                t = Math.min(t, dp[i - j * j]);
            }
            dp[i] = t + 1;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // 3
        System.out.println(numSquares(12));
    }
}
