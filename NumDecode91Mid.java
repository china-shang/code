class NumDecode91Mid{
    // f(n) = '0' == c ? 0 :(f(n-1) + c1 * 10 + c2 >= 10 && <= 26 ? f(n-2) : 0)
    public static int numDecodings1(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        int beforeBefore = 1, before = s.charAt(s.length() -1) == '0' ? 0 : 1;
        for(int i = s.length() - 2; i >=0;i--){
            // int num = Integer.valueOf(s.substring(i, i + 2));
            int num = (s.charAt(i) - '0') * 10 + s.charAt(i+1) - '0';
            int t = s.charAt(i) == '0' ? 0 : (before + (num >= 10 && num <= 26 ? beforeBefore : 0));
            beforeBefore = before;
            before = t;
        }

        return before;
    }
    public static int numDecodings(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        return numDecodings(s, 0);
    }

    public static int numDecodings(String s, int pos){
        // 必须放在前面,不然会被前置返回
        if(pos < s.length() && s.charAt(pos) == '0'){
            return 0;
        }
        if(pos >= s.length() - 1){
            return 1;
        }
        int num = Integer.valueOf(s.substring(pos, pos+2));
        int res = numDecodings(s, pos+1) + (num >= 10 && num <=26 ? numDecodings(s, pos+2): 0);
        return res;
    }

    public static void main(String[] args) {
        // 2
        System.out.println(numDecodings("16"));
        System.out.println(numDecodings1("16"));
        // 3
        System.out.println(numDecodings("116"));
        System.out.println(numDecodings1("116"));
        // 3
        System.out.println(numDecodings("016"));
        System.out.println(numDecodings1("016"));

    }
}
