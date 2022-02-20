import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class MajorityElement229Mid {
    // map存下出现的次数,如果次数>n/3,加入res
    // 如果n/3不能整除，即为n.x，t>n 即为n+1,必定大于n.x
    // 遇到符合的nums[i]直接加入res,避免再次遍历
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int a = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int t = map.getOrDefault(nums[i], 0) + 1;
            if(t > a){
                res.add(nums[i]);
                map.put(nums[i], Integer.MIN_VALUE);
            } else {
                map.put(nums[i], t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 6,1,1,1,2,2,2}));
    }
}
