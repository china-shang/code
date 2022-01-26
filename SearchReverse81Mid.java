class SearchReverse81Mid{
    // 直接利用两段有序列表,根据mid处于的段,以及target的位置,分别排除一段
    // 如果出现   /
    //         --/  /--
    //             /
    //然后mid落在相等的地方,如果是在左侧,往右,如果是在右侧,往左,无法处理
    //只会出现在最左最右都是nums[mid]才会出现这种情况,依据排除法,此时排除最左和最右
    //直到不再同时为nums[mid],可根据nums[l]进行区分两段

    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int l = 0, r = nums.length - 1, mid;
        while(l <= r){
            mid = (r - l >> 1) + l;
            if(nums[mid] == target){
                return true;
            }
            if(nums[l] == nums[mid] && nums[r] == nums[mid]){
                l++;
                r--;
                continue;
            }
            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(target < nums[l] && target > nums[mid]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

    }
}
