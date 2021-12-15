import java.util.Arrays;
public class TwoSum167 {
    public static int[] twoSum(int[] numbers, int target) {
        for(int i = 0,j=numbers.length-1; i<j;i++){
            while(j>i && numbers[i] + numbers[j] > target){
                j--;
            }
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            }

        }
        return new int[]{};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,3,5,6,7}, 11)));

    }
}
