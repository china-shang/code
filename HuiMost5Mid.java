class HuiMost5Mid {
    public static String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        int len = 1, n = s.length(), start=0;

        for(int i=0; i < n; i++){
            int j = 1;
            while(i-j >= 0 && i + j < n){
                if(s.charAt(i-j) != s.charAt(i + j)){
                    break;
                }
                j++;
            }
            j--;
            if( j * 2 + 1 > len){
                len = j * 2 + 1;
                start = i - j;
            }

            j = 1;
            while(i + 1 -j >= 0 && i + j < n){
                if(s.charAt(i+1-j) != s.charAt(i+j)){
                    break;
                }
                j++;
            }
            j--;
            if( j * 2 > len){
                len = j * 2;
                start = i + 1 - j;
            }
        }
        return s.substring(start, start + len );
    }
    public static void main(String[] args) {
        // asdffdsa
        System.out.println(longestPalindrome("basdffdsaasjdf"));

        // asdfdsa
        System.out.println(longestPalindrome("casdfdsaasjdf"));

    }

}
