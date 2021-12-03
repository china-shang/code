import java.util.Arrays;
import java.util.*;

class MaxSubArraySum53 {
    // 穷举法
    // 遍历所有的子数组，找到最大值
    public static int maxArray(int[] arr){

        int maxSum = 0;
        for(int i = 0; i< arr.length; i++){
            int sum = 0;
            for(int j = i; j< arr.length;j++){
                sum += arr[j];
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }

        return maxSum;
    }

    public static int maxArraySpilit(int[] arr){
        return maxArraySpilit(arr, 0, arr.length - 1);
    }

    // 分治法
    // 把数组拆分为两端 最大值要么在左边 要么在右边 要么在左右之间
    // 递归寻找最大值.
    // 查找左右两边的最大值 递归查找子数组的最大值
    // 查找左右之间的最大值 从mid到最左遍历左侧的最大值 从mid+1到最右便利最右侧
    // 的最大值，两值相加
    public static int maxArraySpilit(int[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int mid = (right - left) / 2 + left;
        System.out.println(String.format("%d %d %d", left, mid ,right));
        int leftMax = maxArraySpilit(arr, left, mid);
        int rightMax = maxArraySpilit(arr, mid+1, right);
        int crossMax = maxCrossArray(arr, left, mid, right);

        return Math.max(leftMax, Math.max(rightMax, crossMax));
    }

    public static int maxCrossArray(int[] arr, int left, int mid, int right){
        int leftMax = Integer.MIN_VALUE,rightMax = Integer.MIN_VALUE, sum = 0;
        // 从mid向左加，遇到的最大值就是左边的最大数组值
        for(int i = mid; i>=left ; i--){
            sum+=arr[i];
            leftMax = Math.max(sum , leftMax);
        }

        sum = 0;
        // 从mid+1往右加，遇到的最大值就是右边的最大值
        for(int i=mid+1; i<=right; i++){
            sum+=arr[i];
            rightMax = Math.max(sum, rightMax);
        }

        // 两个最大值相加
        return leftMax + rightMax;
    }


    public static void main(String[] args) {
        System.out.println(maxArray(new int[]{1,-3,2,4,3,-5,6,-3}));
        System.out.println(maxArraySpilit(new int[]{1,-3,2,4,3,-5,6,-3}));
        // 10
    }
}
