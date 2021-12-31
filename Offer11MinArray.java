class Offer11MinArray {
    public static int minArray(int[] nums){
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        // 1
        System.out.println(minArray(new int[]{5,6,7,8,1,1,1,2,3,4}));

        // 1
        System.out.println(minArray(new int[]{1}));

        // 1
        System.out.println(minArray(new int[]{1, 2, 3, 4}));

    }
}
