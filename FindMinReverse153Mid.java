class FindMinReverse153Mid {
    // 如果旋转的结果和原先不一致，最小值必定在右侧,否则最小值为nums[0]
    // 默认min=nums[0],mid在左侧就往右边找，mid在右侧就更新min，然后继续往左找更小值
    // 如果始终在左侧，说明与原来数组一致，min为默认值nums[0]
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        int min = nums[0];
        while(left <= right){
            int mid = (right - left >> 1) + left;
            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else {
                min = nums[mid];
                right = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        // 1
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6}));

        // 1
        System.out.println(findMin(new int[]{4, 5, 6, 1, 2, 3}));
    }
}
