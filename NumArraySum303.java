public class NumArraySum303 {
    private int[] sums;

    public NumArraySum303(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        sums[0] = 0;
        for(int i = 1; i <= n; i++){
            sums[i] = sums[i-1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

    public static void main(String[] args) {
        NumArraySum303 a = new NumArraySum303(new int[]{1,2,3,4,5,6});
        // 2
        System.out.println(a.sumRange(1,1));

        // 3
        System.out.println(a.sumRange(0,1));

        // 9
        System.out.println(a.sumRange(1,3));
    }
}

