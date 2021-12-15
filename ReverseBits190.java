class ReverseBits190 {
    public static int reverseBits(int n){
        int ans = 0;
        for(int i=0; i<32 && n!=0; i++){
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3) == -1073741825);

    }
}
