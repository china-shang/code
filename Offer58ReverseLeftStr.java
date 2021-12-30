class Offer58ReverseLeftStr{
    // sb可以append char; String 可以+char, String可以通过char[]构造,substring(start,n)
    public static String reverseLeftWords1(String s, int n){
        if(s == null || s.isEmpty() || n >= s.length()){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static String reverseLeftWords(String s, int n){
        if(s == null || s.isEmpty() || n >= s.length()){
            return s;
        }
        String prefix = s.substring(0, n);
        char[] cs = new char[s.length()];
        for(int i=n; i < s.length(); i++){
            cs[i - n] = s.charAt(i);
        }
        for(int i = 0; i < prefix.length(); i++){
            cs[i + s.length() - n] = prefix.charAt(i);
        }
        return new String(cs);
    }


    public static void main(String[] args) {
        // cdefab
        System.out.println(reverseLeftWords("abcdef", 2));
        System.out.println(reverseLeftWords1("abcdef", 2));

    }
}
