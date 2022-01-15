class Offer65Add {
    public static int add(int a, int b){
        while(b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }


    public static int add2(int a, int b){
        while(b != 0){
            int t = a ^ b;
            b = (a & b) << 1;
            a = t;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(1234 + 4321 == add(1234, 4321));
        System.out.println(1234 + 4321 == add2(1234, 4321));
    }
}
