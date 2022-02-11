class ZeroCount172Mid{
    // n!有多少个零10 = 5 * 2，2的个数大于5，所以就是求5的个数
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n != 0){
            n /= 5;
            count += n;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
        // 7
        System.out.println(trailingZeroes(30));
    }
}
