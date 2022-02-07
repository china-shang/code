import java.util.Set;
import java.util.HashSet;

class SingleNum137{
    // 3倍集合和然后与数组和做差,/2得到答案
    // 需要使用long作为total.
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long t1 = 0;
        for(int i: nums){
            set.add(i);
            t1 += i;
        }
        long t2 = 0;
        for(long i: set){
            t2 +=  i * 3;
        }
        return (int)((t2 - t1) / 2);
    }
    public static void main(String[] args) {

    }
}
