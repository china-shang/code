
import java.util.Arrays;
class InsertSort {

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0 && arr[j-1] > arr[j];j--){
                swap(arr, j-1, j);
            }

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
