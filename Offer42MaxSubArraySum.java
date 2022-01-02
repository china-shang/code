class Offer42MaxSubArraySum {
    // 方案：0-n的最大sum，if maxSum(0, n-1) < 0 : nums[n] : maxSum[n-1] + nums[n]
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int max=sums[0];
        for(int i = 1; i < sums.length ;i++){
            sums[i] = sums[i-1] > 0 ? nums[i] + sums[i-1] : nums[i];
            max = max > sums[i] ? max : sums[i];
        }
        return max;

    }
    public static void main(String[] args) {

    }
}
