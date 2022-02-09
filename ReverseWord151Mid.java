class ReverseWord151Mid{
    public static String reverseWords(String s) {
        s = s.trim();
        String res = "";
        for(int i = 0, j=0; i < s.length(); i=j){
            while(j < s.length() && s.charAt(j) != ' '){
                j++;
            }
            res = s.substring(i, j) + " " + res;
            while(j < s.length() && s.charAt(j) == ' '){
                j++;
            }
        }

        return res.trim();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords(" abc def ghi jkl "));
    }
}
