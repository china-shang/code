import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class FindRepeatDNA187Mid {
    // 有n-9种字符串需要判断是否重复，最快的判断法为O(1).
    // 使用set存下所有的字符串，直接判断是否重复
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String sub = s.substring(i, i + 10);
            if(set.contains(sub)){
                res.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
