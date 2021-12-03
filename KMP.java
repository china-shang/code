import java.util.Arrays;

class KMP {

    public static int kmp(String s1, String s2){
        int m=s1.length(), n=s2.length();
        if(n == 0){
            return 0;
        }
        int[] pi=new int[n];
        for(int i=1,j=0; i<n;i++){
            while(j>0 && s2.charAt(i) != s2.charAt(j)){
                j = pi[j-1];
            }
            if( s2.charAt(i) == s2.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        // for (int i = 0, j = 0; i < m; i++) {
        for(int i=0,j=0; i < m; i++){
            // while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
            while(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = pi[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == n) {
                return i - n + 1;
            }
        }

        // for(int i=0,j=0;i<m;i++){
            // if(j>0 && s1.charAt(i) != s2.charAt(j)){
                // j = pi[j-1];
            // }
            // if( s1.charAt(i) == s2.charAt(j)){
                // j++;
            // }
            // if(n == j){
                // return i - n + 1;
            // }
        // }


        return -1;
    }

    public static int strStr(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(n == 0){
            return 0;
        }
        int[] pi = new int[n];
        for(int i=1, j=0; i<n; i++){
            while(j>0 && s1.charAt(i) != s2.charAt(j)){
                j = pi[j - 1];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        for(int i=0, j=0; i<m; i++){
            while(j>0 && s1.charAt(i) != s2.charAt(j)){
                j = pi[j-1];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            if(j == n){
                return i - n + 1;
            }
        }
        return -1 ;
    }




    public static void main(String[] args) {
        System.out.println(kmp("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb",
                    "abbabbbabaa"));
        System.out.println(strStr("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb",
                    "abbabbbabaa"));


    }
}
