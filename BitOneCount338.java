class BitOneCount338{
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n ;i++){
            int c = 0, x = i;
            while(x > 0){
                c++;
                x &= x-1;
            }
            res[i] = c;
        }
        return res;
    }
}
