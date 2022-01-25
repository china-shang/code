import java.util.List;
import java.util.ArrayList;

class Comb77Mid {
    private static List<List<Integer>> res;
    // 需要所有的可能,所以就是穷举出所有结果
    // 每次固定前n个,然后开始穷举, 所以不能选到前面的元素,因为之前已经遍历过了
    // now + k > n 如n-1 2 > n,必定不能构成k个,剪枝
    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        combine1(n, k, new ArrayList<>(), 0);
        return res;
    }
    public static void combine1(int n, int k, List<Integer> path, int now){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(now + k > n){
            return;
        }
        for(int i = now + 1; i <= n; i++){
            path.add(i);
            combine1(n, k-1, path, i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        //[
        // [2,4],
        // [3,4],
        // [2,3],
        // [1,2],
        // [1,3],
        // [1,4],
        // ]
        System.out.println(combine(4, 2));
        System.out.println(combine(4, 3));
    }
}
