import java.util.TreeSet;

class ContainsNear220Mid{
    // 滑动窗口 和左边最多k个进行比较 维护一个最多k个的窗口
    // 本来需要和左边的每一个进行比较 但是如果窗口有序的话
    // 如果找到一个[nums[i] - t, nums[i] + t]之间的数就行了
    // 即x >= a && x <= b
    // 可以分步找先找<=b的元素，在符合条件的元素中找最大的,如果>=a即找到
    // 使用floor(a): <=a最大的
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Long num = set.floor((long)nums[i] + t);
            if(num != null && num >= (long)nums[i] - t){
                return true;
            }
            set.add((long)nums[i]);
            if(i >= k){
                set.remove((long)(nums[i - k]));
            }
        }

        return false;
    }
    // 穷举法 每个和右边最多k个进行比较
    // 时间复杂度O(nk)
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0){
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length && j <= i + k; j++){
                if(Math.abs((long)nums[j] - nums[i]) <= t){
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        // false
        System.out.println(containsNearbyAlmostDuplicate(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 1 , 2));
        // false
        System.out.println(containsNearbyAlmostDuplicate1(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 1 , 2));
    }
}
