
class MaxWater11Mid {
    // 方案一：暴力穷举 穷举所有的组合，时间复杂度O(n^2)
    // 方案二：两个指针分别指向头尾，接下来本来有两种可能，左移或右移，如果没一步要么左移要么右移
    // 但是每次移动更大的端，都会导致面积必定更少，所以每次放弃移动大端，每次都移动小端
    // 需要n步时间复杂度为O(n)
    public static int maxWater(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = 0;
        for(int i = 0, j = nums.length - 1; i < j;){
            int size = Math.min(nums[i], nums[j]) * (j - i);
            if(size > max){
                max = size;
            }
            if(nums[i] < nums[j]){
                i++;
            } else {
                j--;
            }

        }
        return max;
    }
    public static void main(String[] args) {
        // 49
        System.out.println(maxWater(new int[]{1, 8, 6, 2, 5, 4, 8 ,3, 7}));

        // 16
        System.out.println(maxWater(new int[]{4, 3 ,2, 1, 4}));
    }
}
