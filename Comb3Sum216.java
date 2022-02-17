import java.util.List;
import java.util.ArrayList;

class Comb3Sum216 {
    private static List<List<Integer>> res ;
    public static List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(0, k,  n, new ArrayList<>());
        return res;
    }

    // 回溯法 一步步走，试探每一种走法 走完了换条路走
    // i 决定还有哪些路 k,n决定是否走完 path之前走的路
    // 不重复说明结果必定递增,如果变小了,在前面就已经有这条结果了
    public static void dfs(int i, int k, int n, List<Integer> path){
        if(k == 0 && n == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(k == 0 || n == 0){
            return;
        }
        for(int j = i + 1; j <= n && j <= 9; j++){
            path.add(j);
            dfs(j, k-1, n - j, path);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 6));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(2, 18));
        System.out.println(combinationSum3(9, 45));
    }
}
