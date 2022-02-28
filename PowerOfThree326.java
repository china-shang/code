
class PowerOfThree326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 3 == 0 && n != 1){
            n /= 3;
        }
        return n == 1;
    }
    // 方案二,如果最大的3的power % n == 0,那么是
    public static void main(String[] args) {

    }
}
