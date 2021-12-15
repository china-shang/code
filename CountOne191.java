class CountOne191 {
    public static int hammingWeight(int n){
        int ans = 0;
        while(n != 0){
            if((n & 1) == 1){
                ans++;
            }
            n >>>= 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        // 6
        System.out.print(hammingWeight(0b101010101001));

    }
}
