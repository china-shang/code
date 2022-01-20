import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Group49Mid {
    // 方案一,穷举,每一个和其他的进行比较,如果是,则list.add(str)
    // 方案二:只要找到str对应的list,然后list.add(str)就行了.
    // 问题变为了使用异构str的共同点作为key,找list
    // 可以使用排序后的str作为key,
    // 保存key->list的关系,
    // 可以使用每个字符出现的次数作为key
    // 保存arr -> list的关系
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] arr = new int[26];
            for(char c: str.toCharArray()){
                arr[c-'a']++;
            }
            String key = "";
            for(int i = 0; i < arr.length; i++){
                key += (char)('a' + i);
                key += arr[i];
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            // 可能第一次出现这个key
            map.put(key, list);

        }
        return new ArrayList<>(map.values());
    }
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String strSorted = new String(cs);
            List<String> list = map.getOrDefault(strSorted, new ArrayList<>());
            list.add(str);
            // 可能第一次出现这个str
            map.put(strSorted, list);
        }

        return new ArrayList<>(map.values());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        boolean[] has = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            while(i < strs.length && has[i]){
                i++;
            }
            if( i == strs.length){
                break;
            }
            has[i] = true;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            Map<Character, Integer> map = new HashMap<>();
            for(char c: strs[i].toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for(int j = i + 1; j < strs.length; j++){
                while(j < strs.length && has[j]){
                    j++;
                }
                if( j == strs.length){
                    break;
                }
                Map<Character, Integer> map1 = new HashMap<>();
                for(char c: strs[j].toCharArray()){
                    map1.put(c, map1.getOrDefault(c, 0) + 1);
                }
                if(same(map, map1)){
                    has[j] = true;
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }

        return res;
    }
    public static boolean same(Map<Character, Integer> m1, Map<Character, Integer> m2){
        for(Map.Entry<Character, Integer> entry: m1.entrySet()){
            if(entry.getValue() != m2.getOrDefault(entry.getKey(), -1)){
                return false;
            }
        }
        for(Map.Entry<Character, Integer> entry: m2.entrySet()){
            if(entry.getValue() != m1.getOrDefault(entry.getKey(), -1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        // [[eat, aet, tea], [abc, bca, acb], [def]]
        System.out.println(groupAnagrams(new String[]{"eat", "aet", "tea", "abc", "bca", "acb", "def"}));
        System.out.println(groupAnagrams1(new String[]{"eat", "aet", "tea", "abc", "bca", "acb", "def"}));
        System.out.println(groupAnagrams2(new String[]{"eat", "aet", "tea", "abc", "bca", "acb", "def"}));

    }
}
