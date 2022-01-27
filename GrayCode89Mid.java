import java.util.List;
import java.util.ArrayList;

class GrayCode89Mid {
    private static boolean[] has;
    // 或0 不变 异或0不变 与1不变
    // 或1 变1 异或1变相反 与0变0
    public static List<Integer> grayCode(int n) {
        int m = (int)Math.pow(2, n);
        has = new boolean[m];
        List<Integer> codes = new ArrayList<>();
        grayCode(codes, m, 0);
        return codes;
    }
    public static boolean grayCode(List<Integer> codes, int m, int now){
        if(now == 0){
            codes.add(0);
            has[0] = true;
            return grayCode(codes, m, 1);
        }
        if(now == m){
            if(diff1(codes.get(0), codes.get(m-1))){
                return true;
            } else {
                return false;
            }
        }
        int t = 1;
        while(t < m){
            int newNum = t ^ codes.get(codes.size() - 1);
            if(!has[newNum]){
                has[newNum] = true;
                codes.add(newNum);
                if(grayCode(codes, m, now+1)){
                    return true;
                }
                has[newNum] = false;
                codes.remove(codes.size() - 1);
            }
            t <<= 1;
        }

        return false;
    }
    public static boolean diff1(int a, int b){
        int t = a ^ b;
        while(t != 0){
            if( (t & 1) == 1){
                return (t>>>1) == 0;
            }
            t >>>= 1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
