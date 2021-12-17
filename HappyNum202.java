import java.util.Set;
import java.util.HashSet;
class HappyNum202 {
    public static boolean isHappy(int n) {
        int sum=n;
        Set<Integer> set = new HashSet<>();
        while(sum != 1){
            n = sum;
            sum = nextNum(n);
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
        }
        return true;

    }
    /*
     *
     * 快慢指针,一个走一步，一个走两步
     */
    public static boolean isHappy1(int n){
        int sum1 = n;
        int sum2 = n;
        while(sum2 != 1){
            sum1 = nextNum(sum1);
            sum2 = nextNum(nextNum(sum2));
            if(sum2 == sum1){
                return false;
            }
        }
        return true;
    }

    public static int nextNum(int n){
        int sum = 0;
        while( n != 0 ){
            int i = n % 10;
            sum += i * i;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(20));
        System.out.println(isHappy(21));

        System.out.println(isHappy1(19));
        System.out.println(isHappy1(20));
        System.out.println(isHappy1(21));
    }
}
