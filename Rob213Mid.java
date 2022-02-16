
class Rob213Mid {
    // f(n)代表0-n的最大值,第n个偷了f(n) = nums[n] + f(n-2), 第n个没有偷f(n) = f(n-1)
    // f(n) = max(nums[n] + f(n-2), f(n-1)
    // 第一和最后不能同时偷,拆分为两种情况第一没偷和最后没偷.又包含3种情况.01 10 00,取最大值
    // max(rob(0~n-2), rob(1,n-1))
    // 预检排除1 和 2的情况
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        } else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public static int rob(int[] nums, int l, int r){
        int a = nums[l], b = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++){
            int t = Math.max(a + nums[i], b);
            a = b;
            b = t;
        }
        return b;
    }
    public static void main(String[] args) {
        // 4
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
