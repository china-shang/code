class IsInterLeaveStr97Mid{
    // 设f(n-1)符合,如果s2的次数多一,结尾必定为s2,加一个s2字符依旧符合.如果加一个s1字符,s1次数加一,依旧符合
    // 同理s1次数多一的情况也是这样,所以s3[i+j-1]成立 = s1(i-1) == s3(i+j-1) && s1[0:i-1] + s2[0:j] = s3[i+j-2]  || s2(j-1) == s3(i+j-1) && s1[0:i] + s2[0:j-1] = s3[i+j-2]
    // 得到公式直接写代码:
    // i,j代表s1,s2长度 不能使用下标,m-1 + n -1 = m + n -2 下标之和小于实际长度,使用长度0-m 0-n -> 0 -> m+n
    // if i > 0; then dp[i-1][j] = s3[i+j-1] = s1[i-1] && dp[i-1][j]
    // 由于只使用了前一行的数据进行递推,使用一行数据进行滚动
    // dp[j] -> dp[0-j-1] 是当前行 dp[j->m]是前一行 把dp[j]计算后存入dp[j],即当前行滚动到上一行上,所以需要先使用dp[j]进行判断,防止收到影响
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null || s3.length() != s1.length() + s2.length()){
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean [] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i > 0){
                    dp[j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[j];
                }
                if(j > 0){
                    dp[j] =dp[j] || s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[j-1];
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(isInterleave("a", "", "c"));
    }
}
