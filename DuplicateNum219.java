import java.util.Map;
import java.util.HashMap;

import java.util.Set;
import java.util.HashSet;
class DuplicateNum219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
    /*
     * 使用set存储滑动窗口，如果窗口大于k,移除最早的元素，如果出现重复的元素，说明在k个内出现了重复
     *
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k){
        Set<Integer> set = new HashSet<>(k);
        for(int i=0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }
    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,5,6,1}, 6));

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,2,6,1}, 2));

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,5,6,1}, 6));

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,2,6,1}, 2));
    }
}
