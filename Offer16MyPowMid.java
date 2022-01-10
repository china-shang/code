class Offer16MyPowMid {
    public static double myPow(double x, int n){
        long n1 = n;
        if(n < 0){
            x = 1 / x;
            n1 = -n1;
        }
        double res = 1;
        while(n1 != 0){
            if((n1 & 1) == 1){
                res *= x;
            }
            x *= x;
            n1 >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, 10) == 1024);
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.00000,-2147483648));

    }
}
