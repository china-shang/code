
class FindTop162Mid{
    // 任选一点，要么是答案，要么答案必定在上升的一边，因为要么一直上升，答案为最右，要么中间就出现答案了
    // 使用二分法进行排除，每次找上升的一边，left mid right答案必定在left-mid-1 或mid+1-right中，
    // left right端要么是最开始的边界，那么符合答案，要么是往中间上升，而中间往固定的一边有事上升的，必定有拐点
    // 使用bigger方法进行比较，处理最左与最右的比较
    public static int findPeakElement(int[] nums) {
        if(nums == null ||nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left >> 1);
            if(bigger(nums, mid, mid-1) && bigger(nums, mid, mid+1)){
                return mid;
            }
            if(bigger(nums, mid + 1, mid)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static boolean bigger(int[] nums, int left, int right){
        int n  = nums.length;
        if(left == -1 || left == n ){
            return false;
        }
        if(right == -1 ||right == n){
            return true;
        }
        return nums[left] > nums[right];
    }
    public static void main(String[] args) {
        // 1 或 5
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
