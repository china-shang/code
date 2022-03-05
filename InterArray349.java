import java.util.Set;
import java.util.HashSet;

class InterArray349{
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for(int i:nums2){
            if(set.contains(i)){
                res.add(i);
            }
        }
        int[] arr = new int[res.size()];
        int i=0;
        for(int num:res){
            arr[i++] = num;
        }
        return arr;
    }
}
