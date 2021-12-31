
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Offer50FirstUniqChar {
    public static char firstUniqChar1(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c: s.toCharArray()){
            if(map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
    public static char firstUniqChar(String s){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return ' ';

    }

    public static void main(String[] args) {
        // g
        System.out.println(firstUniqChar("asdfgasdfio"));
        System.out.println(firstUniqChar1("asdfgasdfio"));
    }
}
