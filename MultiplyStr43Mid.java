class MultiplyStr43Mid{
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        return multiply(num1, num2, num2.length() -1);
    }
    public static String multiply(String num1, String num2, int pos) {
        if(pos < 0){
            return "";
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= num1.length(); i++){
            int t = (num1.charAt(num1.length() - i) - '0') * (num2.charAt(pos) - '0') + flag;
            flag = t / 10;
            sb.append(t % 10);
        }
        if(flag > 0){
            sb.append(flag);
        }
        String res = sb.reverse().toString();

       return add1(multiply(num1, num2, pos-1) + "0", res);
    }
    public static String add1(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        for(int i = num1.length() - 1, j = num2.length() - 1, add=0;i >= 0 || j >= 0 || add > 0; i--,j--){
            int l = i >=0 ? num1.charAt(i) - '0': 0;
            int r = j >=0 ? num2.charAt(j) - '0': 0;
            int t = l + r + add ;
            add = t / 10;
            sb.append(t % 10);
        }
        return sb.reverse().toString();
    }
    public static String add(String num1, String num2){
        int len = num1.length() > num2.length() ? num2.length() : num1.length();
        int flag = 0;
        StringBuilder sb =  new StringBuilder();
        for(int i = 1; i <= len; i++){
            int t = (num1.charAt(num1.length() - i) - '0') + (num2.charAt(num2.length() - i) - '0') + flag;
            flag = t / 10;
            sb.append( t % 10);
        }

        String remainStr = num1.length() > num2.length() ? num1 : num2;
        len++;
        while(remainStr.length() - len >= 0){
            int t = remainStr.charAt(remainStr.length() - len) - '0' + flag;
            sb.append( t % 10);
            flag = t / 10;
            len++;
        }
        if(flag > 0){
            sb.append(flag);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // 7006652
        System.out.println(multiply("1234", "5678"));

        // 1234
        System.out.println(multiply("1234", "1"));

        // 1235243
        System.out.println(multiply("1234", "1001"));

        // 0
        System.out.println(multiply("1234", "0"));

    }
}
