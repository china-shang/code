import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class RemoveDuplicatesArray26 {

    // 用set记录下遇到的每个字符，如果遇到重复的左移+1
    public static int remove(int[] arr){
        if(arr == null){
            return 0;
        }
        int leftRemove = 0;
        Set<Integer> set = new HashSet<>(arr.length);

        for(int i=0; i<arr.length; i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                arr[i-leftRemove] = arr[i];
            }else{
                leftRemove++;
            }
        }
        return arr.length - leftRemove;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 6, 1, 3, 5,9};
        remove(arr);
        System.out.println(Arrays.toString(arr));
    }
}
