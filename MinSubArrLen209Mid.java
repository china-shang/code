import java.util.Arrays;

class MinSubArrLen209Mid {
    // 方案一：暴力穷举 穷举start=0->n-1的数组
    public static int minSubArrayLen(int target, int[] nums) {
        for(int i = 1; i <= nums.length; i++){
            int total = 0;
            for(int j = 0; j < i; j++){
                total += nums[j];
            }
            if(total >= target){
                return i;
            }
            for(int j = 0; j < nums.length - i; j++){
                total = total - nums[j] + nums[j + i];
                if(total >= target){
                    return i;
                }
            }
        }
        return 0;
    }
    // 方案二 滑动窗口 利用前面的数组 以nums[i]开始的数组等于以nums[i-1]开始的数组-nums[i-1]开始计算
    // 如果不是在for中使用if-break而是在for()中第二个参数进行判断，会导致i++执行后才退出
    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        for(int i = 0, j = 0, total=0; i < n; i++){
            total -= i >= 1 ? nums[i - 1] : 0;
            for(; j < n && total < target; j++){
                total += nums[j];
            }
            min = total >= target ? Math.min(j - i, min) : min;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 方案三 前缀和 由于nums[i]>0.所以sums递增,以i+1作为开始的子数组和subArrSum(i) = sums[r] - sums[i]
    // sums长度为n+1,sums[0]代表前0个，sums[i]代表前i个.子数组start∈{0, n-1},sums从抛弃前0个到抛弃前n-1个
    // 使用binarySearch(sums, sums[i] + target)找到大于的最小边界
    // binarySearch return pos或者-insert-1，所以bound < 0, bound = - bound - 1,如果bound<=n,说明找到一个子数组
    // min = bound - i > min ? min : bound - i
    public static int minSubArrayLen2(int target, int[] nums){
        int min = Integer.MAX_VALUE, n = nums.length;
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for(int i = 1; i <= n; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < n; i++){
            int t = sums[i] + target;
            int right = Arrays.binarySearch(sums, t);
            if(right < 0){
                right = -right - 1;
            }
            if(right <= n){
                min = right - i > min ? min : right - i;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen1(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen2(7, new int[]{2,3,1,2,4,3}));
    }
}
