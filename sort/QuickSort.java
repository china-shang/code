import java.util.Arrays;
class QuickSort{

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
        return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int start, int end){
        if(end <= start){
            return ;
        }
        int mid=start,key=arr[end];
        for(int i=start; i<end; i++){
            if(arr[i] <= key){
                swap(arr, i, mid++);
            }
        }
        swap(arr, mid, end);
        sort(arr, start, mid-1);
        sort(arr, mid+1, end);

    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 1, 9 ,7 , 8, 2,7,8,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
