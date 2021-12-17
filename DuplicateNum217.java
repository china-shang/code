import java.util.Set;
import java.util.HashSet;

class DuplicateNum217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[] {1,2,3,4,5,6,7,1}));
        System.out.println(containsDuplicate(new int[] {1,2,3,4,5,6,7}));
    }
}
