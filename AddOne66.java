import java.util.Arrays;
class AddOne66 {
    public static int[] addOne(int[] arr){
        if(arr == null){
            return arr;
        }

        int flag = 1;
        for(int i=arr.length - 1; i>=0; i--){
            int t = arr[i] + flag;
            if(t == 10){
                arr[i] = 0;
                flag = 1;
            } else {
                arr[i] = t;
                flag = 0;
            }
        }
        if(flag == 1){
            int[] res = new int[arr.length + 1];
            res[0] = 1;
            return res;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(addOne(new int[]{ 9, 9, 9})));

    }
}
