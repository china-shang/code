import java.util.Arrays;
class MoveZero283 {
    // 移动到前面
    public static void moveZeroes(int[] nums){
        int moveCount = 0;
        for(int i = nums.length - 1; i >=0 ;i--){
            if(nums[i] == 0){
                moveCount++;
            }else{
                nums[i+moveCount] = nums[i];
            }
        }
        for(int i = 0; i < moveCount; i++){
            nums[i] = 0;
        }
    }

    public static void moveZeroes1(int[] nums){
        int moveCount = 0;
        for(int i = 0; i < nums.length ;i++){
            if(nums[i] == 0){
                moveCount++;
            }else{
                nums[i-moveCount] = nums[i];
            }
        }
        for(int i = 1; i <= moveCount; i++){
            nums[nums.length - i] = 0;
        }
    }

    public static void main(String[] args) {
        // 0001234123
        int[] nums = new int[]{1,2,3,4,0,0,1,2,3,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));

    }
}
