import java.util.Arrays;
class SelectSort {

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIdx = i;
            for(int j = i + 1;j<arr.length; j++){
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            swap(arr, minIdx, i);

        }
    }
    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
        int[] arr = {1 , 9, 0, 2, 7, 6,4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
