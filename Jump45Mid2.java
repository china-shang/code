class Jump45Mid2{
    public static int jump(int[] nums) {
        return jump(nums, 0);
    }
    public static int jump(int[] nums, int pos){
        if(pos >= nums.length - 1){
            return 0;
        }
        int count = nums[pos], min = Integer.MAX_VALUE;
        for(int i = 1; i <= count; i++){
            int t = jump(nums, pos + i);
            min  = min < t ? min : t;
        }
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }

    public static int jump2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int step = 0, end = 0, maxPos = 0;
        //从当前一跳,到下一跳的位置中,找出能够跳的最远距离,作为再下一跳的位置
        //抵达end时,意味这接下来需要继续跳,step++,表示这个阶段找到的最大值,都属于这一跳中即
        //end=maxPos,在当前遍历的节点找到一个跳得最远的节点,作为起点,这一跳抵达的最后位置就是maxPos,并不知道具体的起点是什么
        // 遇到起跳的位置step++,至少需要抵达n+1步,才需要起跳, 所以最后一步已经抵达,不用起跳了
        // 每次抵达之前的最远距离,就需要再次起跳,以抵达后面
        for(int i = 0; i < nums.length - 1; i++){
            maxPos = Math.max(maxPos, nums[i] + i);
            // 上一跳的最远距离已达到,需要继续跳
            if(end == i){
                step++;
                end = maxPos;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        // [2,3,1,1,4] 2
        System.out.println(jump(new int[]{2,3,1,1,4}));

        // [5,9,3,2,1,0,2,3,3,1,0,0] 3
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));

        // [2,3,1,1,4] 2
        System.out.println(jump2(new int[]{2,3,1,1,4}));

        // 3
        System.out.println(jump2(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));

        System.out.println(jump2(new int[]{3}));

    }
}

