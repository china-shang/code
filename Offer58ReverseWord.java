public class Offer58ReverseWord {
    public static String reverseWords1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        s = s.trim();
        // 预排除特殊情况
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1, j = i; j >= 0 ;){
            // 便利字符
            while(j >= 0 && s.charAt(j) != ' '){
                j--;
            }
            sb.append(s.substring(j + 1, i + 1));
            sb.append(' ');
            // 越过空格
            while(j >= 0 && s.charAt(j) == ' '){
                j--;
            }
            i = j;
        }

        return sb.toString().trim();
    }
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        s = " " + s;
        boolean lastIsBlank = true;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1, end = -1; i >=0; i--){
            if(s.charAt(i) == ' '){
                if(!lastIsBlank){
                    lastIsBlank = true;
                    sb.append(s.substring(i+1, end+1));
                    sb.append(' ');
                }
            } else {
                if(lastIsBlank){
                    lastIsBlank = false;
                    end = i;
                }
            }
        }
        if(sb.length() > 0){
            sb = sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        // fff eee ddd cc bb aa
        System.out.println(reverseWords("aa bb cc ddd eee fff"));
        System.out.println(reverseWords1("aa bb cc ddd eee fff"));

    }
}
