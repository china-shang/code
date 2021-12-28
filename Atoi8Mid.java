class Atoi8Mid {
    public static int myAtoi(String s){
        // 排除为空的
        if(s == null || s.length() == 0){
            return 0;
        }
        // 排除所有空格
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
            } else {
                break;
            }
        }
        // 排除长度为0
        if(i == s.length()){
            return 0;
        }
        int ans = 0;
        // 排除符号位
        int sign = s.charAt(i) == '-' ? -1 : 1;
        if( s.charAt(i) == '-' || s.charAt(i) == '+'){
            i++;
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int t = c - '0';
                // 需要判断个位是否超出
                if(sign == -1  && (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && t * -1 < Integer.MIN_VALUE % 10)){
                    return Integer.MIN_VALUE;
                }
                if(sign == 1 &&( ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && t > Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }

                ans = ans * 10 + t * sign;
            } else {
                return ans ;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        // 12340
        System.out.println(myAtoi("  0012340"));

        // -12340
        System.out.println(myAtoi("  -0012340"));

        System.out.println(myAtoi("  00129821218912891289128912340"));
        System.out.println(myAtoi("  -000129821218912891289128912340"));

        // -1234
        System.out.println(myAtoi("   -001234abcd"));

        // 0
        System.out.println(myAtoi("   +-001234abcd"));
    }
}
