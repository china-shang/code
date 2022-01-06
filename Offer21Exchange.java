import java.util.Arrays;

class Offer21Exchange {
    public static int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        for(int i = 0, j = nums.length - 1; i < j; i++, j--){
            // 需要效验是否越界,优化使用i < j
            while(i < j && (nums[i] & 1) == 1){
                i++;
            }
            while(i < j && (nums[j] & 1) == 0){
                j--;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        return nums;
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(exchange(new int[] { 1, 2, 3, 4, 5, 6})));
    }
}
