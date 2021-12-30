class Offer53SearchNum {
    public static int search(int[] nums, int target) {
        int idx = search(nums, 0, nums.length - 1, target);
        if(idx < 0){
            return 0;
        }
        int left = 0, right = 0;
        // 数值判断下标越界
        while(idx -left >= 0 && nums[idx - left] == target){
            left++;
        }
        while(idx + right < nums.length && nums[idx + right] == target){
            right++;
        }
        return left + right - 1;


    }
    public static int search(int[] nums, int left, int right, int target){
        if(right < left){
            return -1;
        }
        int mid = (left + right) >> 1;
        if(nums[mid] == target){
            return mid;
        } if (nums[mid] > target){
            return search(nums, left, mid-1, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        // 3
        System.out.println(search(new int[]{1,2,3,4,4,4,5,6,7}, 4));

    }
}
