import java.util.Arrays;
class Offer57TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[0];
        }
        for(int i = 0, j = nums.length - 1; i < j; ){
            if(nums[i] + nums[j] > target){
                j--;
            } else if(nums[i] + nums[j] < target){
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        // 4 5
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 9)));
        // 5  5
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 5, 5, 6, 7, 8}, 10)));

    }
}
