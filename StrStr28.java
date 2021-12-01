class StrStr28 {

    public static int indexOf1(String s1, String s2){
        if(s2 == null || s2.length() == 0)
            return 0;
        for(int i = 0; i<s1.length() - s2.length() + 1; i++){
            for(int j = 0; j<s2.length(); j++){
                if(s1.charAt(i+j) != s2.charAt(j)){
                    break;
                }
                if(j == s2.length() - 1){
                    return i ;
                }
            }
        }
        return -1;
    }

    public static int indexOf(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && s2.charAt(i) != s2.charAt(j)) {
                j = pi[j - 1];
            }
            if (s2.charAt(i) == s2.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = pi[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public static int indexOf2(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        //
        for(int i=1,j=0; i<m; i++){
            if(j > 0 && s2.charAt(j) != s2.charAt(i)){
                j = pi[j-1];
            }
            if(s2.charAt(i) == s2.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        for(int i=0, j=0; i<n;i++){
            // 需要跳转到最长前缀
            if(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = pi[j-1];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            if(j == m){
                // end 和 start 相差n-1 start = end - n + 1 end = start + n - 1
                return i - m + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(indexOf1("hello", "llo"));
        System.out.println(indexOf1("hello", "lo"));

        System.out.println(indexOf1("hello", "loo"));
        System.out.println(indexOf1("hello", "l1lo"));

        System.out.println("----USING KMP-----");

        System.out.println(indexOf("hello", "llo"));
        System.out.println(indexOf("hello", "lo"));

        System.out.println(indexOf("hello", "loo"));
        System.out.println(indexOf("hello", "l1lo"));

    }
}
