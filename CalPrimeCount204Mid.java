import java.util.Arrays;

class CalPrimeCount204Mid {
    // 埃式筛 首先全部填充为质数，然后使用筛除填充为合数
    // 遇到质数i，从i*i 开始到n全部标记为合数
    // 由于i * i j+=i 可能超出整形，long j = (long) i * i
    // long j = i * i并不能避免溢出,需要(long) i * i
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for(int i=2; i < n; i++){
            if(isPrime[i]){
                count++;
                for(long j = (long)i * i; j < n; j+=i){
                    isPrime[(int)j] = false;
                }

            }
        }
        return count;
    }
    public static void main(String[] args) {
        // 41537
        System.out.println(countPrimes(499979));
        System.out.println(countPrimes(Integer.MAX_VALUE - 8));
    }
}
