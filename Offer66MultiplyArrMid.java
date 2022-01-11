import java.util.Arrays;
class Offer66MultiplyArrMid {
    //
    // 如果能使用除法,计算总和,然后每个值=总和/当前值
    // 如果不能使用除法:分开计算当前值两边的乘积
    // 左边b[0]=1, b[i] = b[i-1] * a[i-1]
    // 右边tmp=1,tmp *= a[i+1]
    // 然后b[0] *= tmp
    public static int[] constructArr(int[] a) {
        if( a == null || a.length == 0){
            return new int[0];
        }
        int[] res = new int[a.length];

        int tmp=1;
        res[0] = 1;
        for(int i = 1; i < a.length; i++){
            res[i] = res[i-1] * a[i-1];
        }
        for(int i=a.length - 2; i >= 0; i--){
            tmp *= a[i + 1];
            res[i] *= tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        // [120,60,40,30,24]
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));

        // [k
        System.out.println(Arrays.toString(constructArr(new int[]{})));
    }
}
