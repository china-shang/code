import java.util.Arrays;

class MultiOther238Mid {
    // 方案一,左右进行叠乘,left[i] 代表i左边所有积 rigth[i] 代表i右边所有积
    // res[i] = left[i] * right[i]
    public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int n = nums.length;
        int[] left = new int[n], right = new int[n], res = new int[n];
        left[0] = 1;
        for(int i = 0 ; i < n - 1; i++){
            left[i + 1] = left[i] * nums[i];
        }
        right[n-1] = 1;
        for(int i = n - 1;i > 0; i--){
            right[i - 1] = right[i] * nums[i];
        }
        for(int i = 0; i < n; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
    // 方案二,只使用res数组
    // res存left数组,然后从i-1,求到0
    // 使用t从1叠乘到nums[1]
    // res[i] = res[i] * t; t *= nums[i];
    public static int[] productExceptSelf1(int[] nums){
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 0 ; i < n - 1; i++){
            res[i + 1] = res[i] * nums[i];
        }
        int t = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * t;
            t *= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
