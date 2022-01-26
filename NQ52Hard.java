import java.util.Set;
import java.util.HashSet;
class NQ52Hard{
    public static int totalNQueens(int n) {

        return dfs(new HashSet<>(), new HashSet<>(), new HashSet<>(), 0, n);
    }

    // dfs就是一棵树, total=所有叶子节点的值之和
    // 如果path路径长度=n,return 1
    // 如果path路径小于n,且无调用,说明是子节点且未完成,return 0
    public static int dfs(Set<Integer> cols, Set<Integer> add, Set<Integer> dec, int row, int n){
        if(row == n){
            return 1;
        }
        int total = 0;
        for(int col = 0; col < n; col++){
            int addNum = col + row;
            int decNum = col - row;
            if(cols.contains(col) || add.contains(addNum) || dec.contains(decNum)){
                continue;
            }
            add.add(addNum);
            dec.add(decNum);
            cols.add(col);
            total += dfs(cols, add, dec, row + 1, n);
            add.remove(addNum);
            dec.remove(decNum);
            cols.remove(col);
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
        System.out.println(totalNQueens(2));
        System.out.println(totalNQueens(3));
        System.out.println(totalNQueens(4));
    }
}
