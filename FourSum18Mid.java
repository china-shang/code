import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class FourSum18Mid {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 3;i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            // 如果有一个long,计算结构为long
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2;j++){
                if(j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }
                for(int k=j+1, l = nums.length-1; k < l;){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum > target){
                        l--;
                    }
                    if(sum < target){
                        k++;
                    }
                    if(sum == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[++k] == nums[k-1]){
                        }
                    }
                }
            }
        }

        return list;
    }
    public static void main(String[] args) {

        // 输入：nums = [1,0,-1,0,-2,2], target = 0
        // 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));

        // [0,0,0,-1000000000,-1000000000,-1000000000,-1000000000]
        // -1000000000
        System.out.println(fourSum(new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000}, -1000000000));

    }
}
