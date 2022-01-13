class Offer14CuttingMid {
    private static int max;
    public static int cuttingRope(int n){
        max = 0;
        cuttingRope(1, n);
        return max;
    }
    public static int cuttingRope1(int n){
        if(n < 3){
            return n - 1;
        }
        if( n % 3 == 1){
            return (int)Math.pow(3.0, n / 3 - 1) * 4;
        }
        if( n % 3 == 0){
            return (int)Math.pow(3.0, n / 3);
        }
        return (int)Math.pow(3.0, n / 2) * 2;
    }
    public static void cuttingRope(int last,int n){
        if(n == 0){
            max = last > max ? last : max;
            return ;
        }
        for(int i=1; i <= n; i++){
            cuttingRope(last * i, n - i);
        }
    }

    public static void main(String[] args) {

        // 36
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope1(10));
    }
}
