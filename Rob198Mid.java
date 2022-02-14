class Rob198Mid {
    // f(n)[0] = max(f(n-1)[0], f(n-1)[1])
    // f(n)[1] = nums[n] +f(n-1)[0]
    public static int rob(int[] nums) {
        int[] dp = new int[2];
        dp[1] = 0;
        dp[0] = 0;//没偷
        for(int i = 0; i < nums.length; i++){
            int next0 = Math.max(dp[0], dp[1]);
            dp[1] = dp[0] + nums[i];
            dp[0] = next0;
        }
        return Math.max(dp[0], dp[1]);
    }
    public static void main(String[] args) {
        // 12
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
