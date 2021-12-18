public class PowerOfTwo231 {
    public static boolean isPowerOfTwo(int n){
        if(n < 0){
            return false;
        }

        while(n != 0){
            if((n & 1) == 1){
                return (n>>>1) ==0;
            }
            n >>>=1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0b100001000));
        System.out.println(isPowerOfTwo(0b1000000000));

    }
}
