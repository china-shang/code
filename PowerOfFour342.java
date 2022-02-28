
class PowerOfFour342{
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & n-1) == 0 && (n & 0b1010101010101010101010101010101) != 0;
    }
    public static void main(String[] args) {

    }
}
