class AddBinary67{
    public static String add(String a, String b){
        StringBuilder sb = new StringBuilder();
        int l = a.length(), r=b.length();
        int maxLen = l > r ? l : r, carry = 0;

        for(int i = 0; i<maxLen; i++){
            int t1 =l -1 -i >= 0 ?  a.charAt(l - 1 -i) -'0' : 0;
            int t2 = r -1 -i >= 0 ?  b.charAt(r - 1 -i) - '0': 0;
            int t = t1 + t2 + carry;
            if(t >= 2){
                carry = 1;
            }else{
                carry = 0;
            }
            sb.append((char)('0' + t % 2));
        }
        if(carry >= 1){
            sb.append('1');
        }

        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(add("101010", "1010100"));

    }
}
