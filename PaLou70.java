import java.util.Map;
import java.util.HashMap;
class PaLou70 {
    private static Map<Integer, Integer> map = new HashMap<>();
    /**
     * 爬N层有多少种可能=先爬一层的可能数+先爬两层的可能数.
     * 然后递归执行，两步都需要计算1-n层的可能数，所以使用动态规划缓存
     */
    public static int climb(int n){
        if(n <= 2){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int count = climb(n-1) + climb(n - 2);
        map.put(n ,count);

        return count;
    }

    /**
     * f(n) = f(n-1) + f(n-2)反过来看f(3) = f(2) + f(1) f4=f(3)+f(2)可以一直递推到f(n)
     */
    public static int climb1(int n){
        if(n <= 2){
            return n;
        }
        int before=2, beforeBefore = 1, res = 0;
        for(int i = 3; i <= n;i++){
            res = before + beforeBefore;
            beforeBefore = before;
            before = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(climb(2));
        System.out.println(climb(8));

        System.out.println(climb1(2));
        System.out.println(climb1(8));
    }
}
