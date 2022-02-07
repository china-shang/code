import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SplitHui131Mid{
    private static List<List<String>> res;
    private static boolean[][] flags;
    // 回溯法找所有的可能
    // 通过预处理,判断是否可以拆分
    // f(i,j) = f(i+1, j-1) && s[i] == s[j]
    // 先填充为true,然后i从后往前,j从前往后
    public static List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        flags = new boolean[s.length()][s.length()];
        for(int i = 0; i < flags.length; i++){
            Arrays.fill(flags[i], true);
        }
        for(int i = flags.length - 1; i >= 0; i--){
            for(int j = i + 1; j < flags.length; j++){
                flags[i][j] = flags[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return res;
    }
    public static void dfs(String s, int pos, List<String> path){
        if(pos == s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i = pos; i < s.length();i++){
            if(flags[pos][i]){
                path.add(s.substring(pos, i+1));
                dfs(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(partition("abbabbccaa"));
    }
}
