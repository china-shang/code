class NTree96Mid{
    // 先使用dfs,然后根据长度与具体的范围无关,只与范围大小相关,发现重复的子问题
    // f(n) = 左右乘积求和i={1,n}
    // for j=1..i dp[i] += dp[j-1] * dp[i-j]
    public static int numTrees(int n){
        if(n <= 1){
            return 1;
        }
        int num = 0;
        for(int i = 1; i <= n; i++){
            num += numTrees(i-1) * numTrees(n-i);
        }
        return num;
    }
    public static int numTrees1(int n){
        if( n <= 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<=n; i++){
            for(int j=1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees1(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees1(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees1(3));
    }
}
