class MissingNumber268 {
    public static int missingNumber(int[] nums){
        boolean[] existedNums =  new boolean[nums.length + 1];
        for(int i : nums){
            existedNums[i] = true;
        }
        for(int i = 0;i < existedNums.length; i++){
            if(existedNums[i] == false){
                return i;
            }
        }
        return -1;
    }
    public static int missingNumber1(int[] nums){
        int n = nums.length;
        int missing = 0;
        for(int i=0; i<=n; i++){
            missing ^= i;
        }
        for(int i: nums){
            missing ^= i;
        }
        return missing;
    }
    public static int missingNumber2(int[] nums){
        int n = nums.length;
        int sum = (0 + n) * (n + 1) / 2;
        int total = 0;
        for(int i: nums){
            total += i;
        }
        return sum - total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));

    }
}
