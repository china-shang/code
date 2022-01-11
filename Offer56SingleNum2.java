import java.util.Arrays;

class Offer56SingleNum2 {
    public static int[] singleNumbers(int[] nums) {
        int n = 0;
        for(int i: nums){
            n ^=i;
        }
        int dev = 1;
        while((dev & n) == 0){
            dev <<= 1;
        }
        int a=0,b=0;
        for(int i : nums){
            if((dev & i) == 0){
                a ^=i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
    public static void main(String[] args) {
        // 4 5
        System.out.println(Arrays.toString(singleNumbers(new int[] {1,1,2,3,2,3,4,5,6,6})));

    }
}
