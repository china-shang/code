class UglyNum264Mid{
    // 三条递增线 2 * i1, 3 * i2, 5 * i3,每次取最小值
    // i1,i2,i3递增,如果出现相同则同时i++;如果相同必定同时出现
    // dp[i] = min(a,b,c) if dp[i] == a then i1++;
    public static int nthUglyNumber(int n) {
        int[] idxs = new int[]{0, 0 , 0};
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n ; i++){

            int a = dp[idxs[0]] * 2,
            b = dp[idxs[1]] * 3,
            c = dp[idxs[2]] * 5;
            dp[i] = Math.min(a, Math.min(b, c));

            if(a == dp[i]){
                idxs[0]++;
            }
            if(b == dp[i]){
                idxs[1]++;
            }
            if(c == dp[i]){
                idxs[2]++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        // 12
        System.out.println(nthUglyNumber(10));
    }
}
