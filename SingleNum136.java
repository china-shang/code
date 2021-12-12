class SingleNum136 {
    public static int singleNumber(int[] nums){
        int num=0;
        for(int i : nums){
            num ^= i;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,3,5,7,5,3,1}));

    }
}
