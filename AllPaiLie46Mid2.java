import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class AllPaiLie46Mid2 {
    // 分步-回溯, 使用回溯法.选择时有要求,选择的路径必须未被选择过,
    // 使用map存储剩余使用的次数,或者boolean[]存储对应的数字是否被使用,
    // 如果剩余使用次数>0,或者对应位置未使用,选择该路径,dfs完后进行回溯
    // 如果遇到一堆重复数字,选择任一一个,path和剩余的选择都是一致的,所以必定相同
    // 如果遇到重复,跳过第一个之后的数字
    // 使用boolean[] while(vis(i) || (i > 0 && nums[i]==nums[i-1] && !vis(i-1))
    public static List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        Map<Integer, Integer> has = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++){
            has.put(nums[i], has.getOrDefault(nums[i], 0) + 1);
        }
        permute(nums, path, has, res);
        return res;
    }

    public static void permute(int[] nums, List<Integer> path, Map<Integer, Integer> has, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < nums.length; i++){
            while(i > 0 && i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
            if(i < nums.length && has.get(nums[i]) > 0){
                path.add(nums[i]);
                has.put(nums[i], has.get(nums[i]) - 1);
                permute(nums, path, has, res);
                path.remove(path.size() - 1);
                has.put(nums[i], has.get(nums[i]) + 1);
            }
        }
    }
    public static void main(String[] args) {
    // nums = [1,2,3]
    // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    System.out.println(permute(new int[]{1, 2, 3}));

    // [[1,1,3],[1,3,1],[3,1,1]]
    System.out.println(permute(new int[]{1, 1, 3}));

    // [[0,3,3,3],[3,0,3,3],[3,3,0,3],[3,3,3,0]]
    System.out.println(permute(new int[]{3,3,0,3}));
    }
}
