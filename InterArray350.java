import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class InterArray350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for(int i : nums1){
            m1.put(i, m1.getOrDefault(i, 0) + 1);
        }
        for(int i: nums2){
            m2.put(i, m2.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: m1.entrySet()){
            if(m2.containsKey(entry.getKey())){
                int c = Math.min(entry.getValue(), m2.get(entry.getKey()));
                for(int i = 0 ; i<c;i++ ){

                    res.add(entry.getKey());
                }
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        List<Integer> res = new ArrayList<>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length; ){
            while( i < nums1.length && nums1[i] < nums2[j]){
                i++;
            }
            while(j < nums2.length && i < nums1.length && nums2[j] < nums1[i]){
                j++;
            }
            if(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
                res.add(nums2[j]);
                i++;
                j++;

            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {

    }
}
