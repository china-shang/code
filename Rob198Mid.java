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
    private static int  max;
    public static int rob2(int[] nums){
        max = 0;
        dfs(nums, 0, false, 0);
        return max;
    }
    // f(pos+1)[true] = f(pos)[false] + nums[pos]
    // f(pos+1)[false] = Math.max(f(pos)[true], f(pos)[false])
    // f(0)[false] = 0
    // f(0)[true] = Integer.MIN_VALUE;
    // 由dfs倒推动态规划公式
    // 关键因子:下标，值，状态，依赖:pos,sum,before,nums
    // 如果后一项可以由前两项获得，由终止过程推算如何处理
    // 如最后是计算max，那么继续从前两项中选max
    public static void dfs(int[] nums, int pos, boolean before, int sum){
        if(pos == nums.length){
            max = Math.max(sum, max);
        }
        if(before){
            dfs(nums, pos+1, false, sum);
        } else {
            dfs(nums, pos + 1, true, sum + nums[pos]);
            dfs(nums, pos + 1, false, sum);
        }
    }

    public static void main(String[] args) {
        // 12
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
