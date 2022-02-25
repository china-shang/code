
class SuperUglyNum313Mid{
        public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] idx = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int min = primes[0] * dp[idx[0]];
            for(int j = 1; j < primes.length;j++){
                min = Math.min(primes[j]* dp[idx[j]], min);
            }
            for(int j = 0; j < primes.length;j++){
                if(min == primes[j] * dp[idx[j]]){
                    idx[j]++;
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(100, new int[]{2,3,5,7,11}));
        System.out.println(nthSuperUglyNumber(100, new int[]{3, 11}));
    }
}
