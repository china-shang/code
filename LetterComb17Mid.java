import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class LetterComb17Mid {
    private static Map<Character, String> map ;
    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return new ArrayList<>();
        }

        return letterCombinations(new StringBuilder(), digits, 0);
    }

    public static List<String> letterCombinations(StringBuilder has, String digits, int pos){
        if(pos >= digits.length()){
            return Arrays.asList(has.toString());
        }
        List<String> list = new ArrayList<>();
        for(char c :map.get(digits.charAt(pos)).toCharArray()){
            list.addAll(letterCombinations(has.append(c), digits, pos+1));
            has.deleteCharAt(has.length() - 1);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("2234"));

    }
}
