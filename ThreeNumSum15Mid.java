import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeNumSum15Mid {
    // 固定第一位数字（穷举所有的第一位数位置），问题退化为两数之和,然后sum>0,r--,sum<0,l++.while前一个数相同l++，或者r--
    public static List<List<Integer>> threeSum2(int[] nums){
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }
        for(int one = 0; one < n - 2; one++){
            if(one > 0 && nums[one] == nums[one-1]){
                continue;
            }
            for(int two=one+1; two < n - 1; two++){
                if(two > one + 1&& nums[two] == nums[two-1]){
                    continue;
                }
                int num = 0 - nums[one] - nums[two];
                if(map.getOrDefault(num, -1) > two){
                    list.add(Arrays.asList(new Integer[]{nums[one], nums[two], num}));
                }
            }
        }
        return list;
    }
    public static List<List<Integer>> threeSum1(int[] nums){
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int one = 0; one < n - 2;one++){
            if(one > 0 && nums[one] == nums[one-1]){
                continue;
            }
            for(int two = one+1; two < n - 1; two++){
                if(two > one + 1 && nums[two] == nums[two-1]){
                    continue;
                }
                int three = n - 1;
                while(nums[one] + nums[two] + nums[three] > 0 && two < three){
                    three--;
                }
                if(two == three){
                    break;
                }
                if(nums[one] + nums[two] + nums[three] == 0){
                    list.add(Arrays.asList(new Integer[]{nums[one], nums[two], nums[three]}));
                }

            }
        }

        return list;
    }

    public static List<List<Integer>> threeSum(int[] nums){
        if(nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int one = 0; one < nums.length - 2; one++){
            if(one > 0 && nums[one] == nums[one-1]){
                continue;
            }
            int two = one + 1, three = nums.length - 1;
            while(two < three){
                while(two > one + 1 && nums[two] == nums[two-1] && two < three){
                    two++;
                }
                while(three < nums.length - 1 && nums[three] == nums[three + 1] && two < three){
                    three--;
                }
                if(two >= three){
                    break;
                }
                int sum = nums[one] + nums[two] + nums[three];
                if(sum == 0){
                    list.add(Arrays.asList(new Integer[]{nums[one], nums[two], nums[three]}));
                    // two++后sum必定>0
                    two++;
                    // 所以three必定--
                    three--;
                } else if(sum > 0){
                    three--;
                } else {
                    two++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //[[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));

        System.out.println(threeSum1(new int[]{-1,0,1,2,-1,-4}));

        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
}
