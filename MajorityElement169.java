import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class MajorityElement169 {
    public static int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i :nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Map.Entry<Integer, Integer> majEntry = null;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(majEntry == null || majEntry.getValue() < entry.getValue()){
                majEntry = entry;
            }

        }

        return majEntry.getKey();
    }
    public static int majorityElement2(int[] nums){
        sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length / 2];
    }
    public static void sort(int[] nums, int left, int right){
        if(right <= left){
            return;
        }
        int key = nums[right],mid=left;
        for(int i = left; i < right; i++){
            if(nums[i] < key){
                swap(nums, i, mid++);
            }
        }
        swap(nums, mid, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }
    public static void swap(int[] nums, int i, int j){
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,1,1,1,1,1,1,1,2,2,4,5,6,7,8}));
        System.out.println(majorityElement1(new int[]{1,1,1,1,1,1,1,1,1,2,2,4,5,6,7,8}));
        System.out.println(majorityElement2(new int[]{1,1,1,1,1,1,1,1,1,2,2,4,5,6,7,8}));

    }
}
