public class ReverseInt7Mid{
    public static int reverse(int x){
        int ans = 0;
        while(x != 0){
            // 个位最大为2
            if( ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10){
                return 0;
            }
            // 负数的%也是负数
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {

        // -1
        System.out.println(reverse(-1));

        // 54321
        System.out.println(reverse(12345));

        // 54321
        System.out.println(reverse(1234500));

        // 54321
        System.out.println(reverse(-1234500));
    }
}
