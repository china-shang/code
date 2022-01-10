import java.util.Arrays;
class Offer45MinNumberMid {
    public static String minNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return "";
        }
        sort(nums, 0, nums.length - 1);
        String res = "";
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        return res;
    }
    public static void sort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int k = nums[r], mid = l;
        for(int i = l; i < r; i++){
            if(!than(nums[i], k)){
                swap(nums, i, mid++);
            }
        }
        swap(nums, mid, r);
        sort(nums, l, mid-1);
        sort(nums, mid+1, r);
    }

    public static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public static boolean than(int a, int b){
        if(a == 0){
            return false;
        }
        if(b == 0){
            return true;
        }

        long ta = a, tb = b;
        while(ta != 0){
            ta /= 10;
            tb *= 10;
        }
        long ba = tb + a;
        tb = b;
        ta = a;
        while(tb != 0){
            tb /= 10;
            ta *= 10;
        }
        long ab = ta + b;

        return ab > ba;
    }

    public static void main(String[] args) {

        // 12345
        System.out.println(minNumber(new int[]{2, 1, 3, 4, 5}));

        //123345
        System.out.println(minNumber(new int[]{1, 2, 34, 3, 5}));

        //
        System.out.println(minNumber(new int[]{999999998,999999997,999999999}));

        //
        System.out.println(minNumber(new int[]{0,9,8,7,6,5,4,3,2,1}));



    }
}
