import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
class StrIsIsomorphic205 {
    public static boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map1.containsKey(sc) && map1.get(sc) != tc || map2.containsKey(tc) && map2.get(tc) != sc){
                return false;
            }
            map1.put(sc, tc);
            map2.put(tc, sc);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aabbccd", "bbccdde"));
        System.out.println(isIsomorphic("aabbccdc", "bbccddef"));

    }
}
