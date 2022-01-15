class  SearchRange34Mid {
    private static int left ;
    private static int right;
    // 二分查找, 如果查找到后,记录,然后向左找边界,
    // 如果查找到后,记录,然后向右查找边界
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        left = -1;
        right = -1;
        searchLeft(nums, 0, nums.length - 1, target);
        searchRight(nums, 0, nums.length - 1, target);
        return new int[]{left, right};
    }
    public static void searchLeft(int [] nums, int l, int r, int target){
        if(l > r){
            return ;
        }
        int mid = l + (r - l >> 1);
        if(nums[mid] == target){
            left = mid;
            searchLeft(nums, l, mid - 1, target);
        }
        if(nums[mid] > target){
            searchLeft(nums, l, mid -1, target);
        }
        if(nums[mid] < target){
            searchLeft(nums, mid+1, r, target);
        }
    }
    public static void searchRight(int [] nums, int l, int r, int target){
        if(l > r){
            return ;
        }
        int mid = l + (r - l >> 1);
        if(nums[mid] == target){
            right = mid;
            searchRight(nums, mid+1, r, target);
        }
        if(nums[mid] > target){
            searchRight(nums, l, mid -1, target);
        }
        if(nums[mid] < target){
            searchRight(nums, mid+1, r, target);
        }
    }
}
