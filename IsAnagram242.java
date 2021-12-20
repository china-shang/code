import java.util.Map;
import java.util.HashMap;

class IsAnagram242 {
    /**
     * 先判断长度，之后基于长度相等进行
     * 遍历是s1,存储在map中,<c,count>
     * 遍历s2,每次遇见c，令map的count-1。如果不是，必定会令count<0
     *
     */
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c: t.toCharArray()){
            if(map.getOrDefault(c, 0) < 1){
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("aabbccd", "abcabcd"));
        System.out.println(isAnagram("aabbccd", "abcabc"));
        System.out.println(isAnagram("aabbcc", "abcabcd"));

    }
}
