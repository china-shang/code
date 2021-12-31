class Offer53 {
    public static int missingNumber(int[] nums){
        // 整数除法放在后面
        int n = nums.length, sum = n * (n + 1) / 2;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += nums[i];
        }
        return sum - total;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));

    }
}
