import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class AllPaiLie46Mid {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        Set<Integer> has = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, path, has, res);
        return res;
    }

    public static void permute(int[] nums, List<Integer> path, Set<Integer> has, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            if(!has.contains(nums[i])){
                path.add(nums[i]);
                has.add(nums[i]);
                permute(nums, path, has, res);
                path.remove(path.size() - 1);
                has.remove(nums[i]);
            }
        }
    }
    public static void main(String[] args) {
    // nums = [1,2,3]
    // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    System.out.println(permute(new int[]{1, 2, 3}));
    }
}
