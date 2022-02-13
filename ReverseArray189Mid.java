import java.util.Arrays;

class ReverseArray189Mid{
    // 左移需要额外空间，但是反转不需要
    // 先反转，使得后k个在左边，其余的数字在右边,但是顺序不对
    // 然后继续分段反转，使得顺序排列正确
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0, k - 1);
        reverse(nums, k, nums.length - 1);

    }
    public static void reverse(int[] nums, int l, int r){
        while(l < r){
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
    }
    public static void main(String[] args) {
        // 5 6 7 1 2 3 4
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
