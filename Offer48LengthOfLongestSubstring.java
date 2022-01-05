import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
class Offer48LengthOfLongestSubstring{
    // 以尾开始遍历，通常来说有n个尾，每个尾有n个字符串，每个字符串需要n次遍历，需要O(n^3)
    // 当时尾巴为j的最大长度与j-1的最大长度有关
    // 无法直接找到子问题，首先遍历，如果遍历的j,j-1存在关系，可以使用动态规划
    // 动态规划的关键：能够减少问题的规模，就能使用迭代的方式计算,
    // 有无重复子问题影响动态规划减少的复杂度
    // 找转移方程：1:由N直接找到到N-1的方式 2:假设已知N-1求N
    public static int longestSubstring1(String s){
        if(s==null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int before = 0;
        int max = 1;

        for(int i = 0; i < s.length(); i++){
            int idx = map.getOrDefault(s.charAt(i), -1);
            if(idx < i - before){
                before = before + 1;
            } else {
                before = i - idx;
            }
            max = before > max ? before : max;
            map.put(s.charAt(i), i);
        }

        return max;

    }
    public static int longestSubstring(String s){
        Set<Character> set = new LinkedHashSet<>();
        int max = 0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                max = max > set.size() ? max : set.size();
                Iterator<Character> iter = set.iterator();
                while(iter.hasNext()){
                    if(iter.next() != c){
                        iter.remove();
                    }else{
                        iter.remove();
                        break;
                    }
                }
                set.add(c);
            } else {
                set.add(c);
            }
        }
        max = max > set.size() ? max : set.size();
        return max;
    }
    public static void main(String[] args) {
        // 5
        System.out.println(longestSubstring("asdfgasdf"));
        System.out.println(longestSubstring1("asdfgasdf"));

    }
}
