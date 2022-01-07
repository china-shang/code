import java.util.Arrays;
class Offer61IsSun {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length && nums[i] == 0){
            i++;
        }
        int n = i;
        while(i < nums.length - 1 && n >= 0){
            if(nums[i] == nums[i+1]){
                return false;
            }
            n -= nums[i + 1] - nums[i] - 1;
            i++;
        }
        return n >= 0;
        }

    public static void main(String[] args) {

        // true
        System.out.println(isStraight(new int[]{0,0,1,3,5,6,7}));
        //false
        System.out.println(isStraight(new int[]{0,0,1,4,5,6,7,9}));
        System.out.println(isStraight(new int[]{0,0,1,2,2,3,4}));
    }
}
