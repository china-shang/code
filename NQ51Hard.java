import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class NQ51Hard{
    private static List<List<String>> res;
    // 关键两条斜线, y = x + n y = -x + n => y - x = n y + x = n变为行列之和与差相同
    // 每一行选择的每个位置后,下一步为下一行选择位置.分步,并且每一步的选择不能和之前的选择构成直线
    // Arrays.fill(l, '.');
    public static List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        dfs(new int[n], n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }
    public static void dfs(int[] path, int n, int row, Set<Integer> cols, Set<Integer> add, Set<Integer> dec){
        if(row == n){
            res.add(genResult(path));
            return;
        }

        for(int col = 0; col < n; col++){
            int addNum = row + col;
            int decNum = row - col;
            if(cols.contains(col) || add.contains(addNum) || dec.contains(decNum)){
                continue;
            }
            path[row] = col;
            cols.add(col);
            add.add(addNum);
            dec.add(decNum);
            dfs(path, n, row + 1, cols, add, dec);
            cols.remove(col);
            add.remove(addNum);
            dec.remove(decNum);
        }
    }
    public static List<String> genResult(int[] path){
        List<String> list = new ArrayList<>();
        int n = path.length;
        for(int i = 0; i < n; i++){
            char[] t = new char[n];
            Arrays.fill(t, '.');
            t[path[i]] = 'Q';
            list.add(new String(t));
        }

        return list;
    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(1));
        System.out.println(solveNQueens(4));
    }
}
