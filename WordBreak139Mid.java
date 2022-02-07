import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

class WordBreak139Mid{
    // dp[i] = for j ∈ {0, i-1} then  dp[j] && s[j:i-1] ∈ wordDict
    // 由于需要存dp[0] = true, dp[i]代表0-i-1的字符串
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // i的左边为需要的字符串结尾,所以相当于整体右移一格
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                // i 为不包括的字符串
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList(new String[]{"lee", "tco", "de"})));
    }
}
