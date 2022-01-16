class CountAndStay38Mid {
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String last = countAndSay(n - 1);
        char lastChar = last.charAt(0);
        int lastCount = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < last.length(); i++){
            char c = last.charAt(i);
            if(c == lastChar){
                lastCount++;
            } else {
                sb.append(lastCount).append(lastChar);
                lastChar = c;
                lastCount = 1;
            }
        }
        sb.append(lastCount).append(lastChar);
        return sb.toString();
    }
    public static void main(String[] args) {
        // 11
        System.out.println(countAndSay(2));
        //111221
        System.out.println(countAndSay(5));
    }
}
