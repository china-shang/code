class SearchReverse33Mid {
    private static int midIdx;
    // 先找到旋转的位置,然后分别二分查找两边
    // 如何找到位置: 二分mid,如果大于nums[0],右边找,如果小于nums[0],记录并向左边找
    // 如果相等向右边找-如[1, 0]
    // 默认为0,如果未找到小于nums[0]的则相当与全部旋转
    // 如果只有一个元素,那么默认为0
    // 找到位置后, 如果=0,二分查找整个数组
    // 否则查找对应的一段
    // 迭代二分,条件为l <= r
    // l + (r-l >> 1) 位移运算的优先级很低
    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        midIdx = 0;
        findMid(nums, 0, nums.length-1);
        if(midIdx == 0){
            return search(nums, 0, nums.length - 1, target);
        }
        if(target >= nums[0] && target <= nums[midIdx-1]){
            return search(nums, 0, midIdx - 1, target);
        }
        if(target >= nums[midIdx] && target <= nums[nums.length - 1]){
            return search(nums, midIdx, nums.length - 1, target);
        }
        return -1;
    }
    public static int search(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r - l >> 1);
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void findMid(int[] nums, int l, int r){
        if(l > r){
            return;
        }
        int mid = l + (r - l >> 1);
        if(nums[mid] >= nums[0]){
            findMid(nums, mid + 1, r);
        }
        if(nums[mid] < nums[0]){
            midIdx = mid;
            findMid(nums, l, mid - 1);
        }
    }
    public static void main(String[] args) {
        // 1
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 5));

        // 7
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9,1,2,3}, 2));

        // 0
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 9}, 4));

        // 0
        System.out.println(search(new int[]{4}, 4));

        // 1
        System.out.println(search(new int[]{3, 1}, 1));

    }
}
