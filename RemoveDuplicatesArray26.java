import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class RemoveDuplicatesArray26 {

    // 利用有序性,相同的数字必定一起出现,使用双指针
    // 遍历需要左移的数字时,下一他跳为下一个不同的数字
    // 遇到相同j++,removeCount++ 最后i=j,j++
    // 遍历到需要左移的数字后,左移removeCount位
    public static int remove1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int leftRemove = 0;

        for(int i=0, j=1; i<arr.length; i=j,j++){
            arr[i - leftRemove] = arr[i];
            while(j < arr.length && arr[i] == arr[j]){
                j++;
                leftRemove++;
            }
        }
        return arr.length - leftRemove;
    }

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

        int[] arr1 = {1, 1, 2, 3, 4, 5, 5,6, 6};
        remove1(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
