import java.util.Arrays;

class ThreeSumClosest16Mid {
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return target;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++){
            for(int j=i+1, k = nums.length - 1; k > j && ans != target;){
                int sum = nums[i] + nums[j] + nums[k];
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum : ans;
                if(sum > target){
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        //nums = [-1,2,1,-4], target = 1
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));

    }
}
