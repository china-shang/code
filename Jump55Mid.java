class Jump55Mid{
    // 更新当前阶段下能抵达的最远距离,如果i>max,说明当前跳跃的最远距离小于了i,return false
    // 如果i == length-1 都能抵达,则可达最后一位
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i > max){
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
