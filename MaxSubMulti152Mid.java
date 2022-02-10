class MaxSubMulti152Mid{
    // 穷举 以i结尾的所有最大乘积
    // max[i] = nums[i] > 0 ? nums[i] * max(1, max[i-1]) : nums[i] * min(min[i-1], 1)
    // min[i] = nums[i] > 0 ? nums[i] * min(1, min[i-1]) : nums[i] * max(max[i-1], 1)
    // min[i] = max[i] = 0 if nums[i] == 0
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxPro = nums[0], min = 1, max = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                max = 0;
                min = 0;
            }
            if(nums[i] > 0){
                if(max > 1){
                    max = nums[i] * max;
                } else {
                    max  = nums[i];
                }
                if(min < 1){
                    min = nums[i] * min;
                } else {
                    min = nums[i];
                }
            } else {
                int nextMax = 0;
                if(min < 1){
                    nextMax = nums[i] * min;
                } else {
                    nextMax = nums[i];
                }
                if(max > 1){
                    min = nums[i] * max;
                } else {
                    min = nums[i];
                }
                max = nextMax;
            }
            maxPro = maxPro > max ? maxPro : max;
        }
        return maxPro;
    }
    public static void main(String[] args) {
        // 240
        System.out.println(maxProduct(new int[]{2, 2, 3, 4,5}));
        // 120
        System.out.println(maxProduct(new int[]{-1, -2, -3, -4,-5}));

        // 60
        System.out.println(maxProduct(new int[]{1, -2, -3, 4, -5}));
    }
}
