import java.util.HashMap;
import java.util.Map;
import java.util.List;
class WordPattern290 {
    public static boolean wordPattern(String pattern, String s){
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length){
            return false;
        }
        Map<String, Character> map1 = new HashMap<>();
        Map<Character,String> map2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            if(!map1.containsKey(strs[i])){
                map1.put(strs[i], pattern.charAt(i));
            } else if (map1.get(strs[i]) != pattern.charAt(i)){
                return false;
            }
            if(!map2.containsKey(pattern.charAt(i))){
                map2.put(pattern.charAt(i), strs[i]);
            } else if (!map2.get(pattern.charAt(i)).equals(strs[i])){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        // true
        System.out.println(wordPattern("abcdabcd", "aa bb cc dd aa bb cc dd"));
        // false
        System.out.println(wordPattern("abcdabcf", "aa bb cc dd aa bb cc cc"));
        // false
        System.out.println(wordPattern("abcdabcda", "aa bb cc dd aa bb cc dd ee"));

    }
}
