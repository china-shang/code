import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SubSetDup90Mid{
    private static List<List<Integer>> res ;
    // 同一层决定的是选哪个相同的数字,选了第一个,后面的就不用选了
    // 因为选后面的相同数字,path相同,后面的可选项目是之前的子集,结果集必定和之前重复
    // 不同层次第一个选择决定的是否多选,所以第一个与前面重复了不算重复,选择的次数不同导致path不同,
    // 并且只有这一次选了n次,所以必定不会重复
    // 第i层选了n个,只有第i+1层遍历了n个作为前缀的可能,然后开启了n+1的调用,继续在下一层遍历
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            select(nums, 0, new ArrayList<>(), i);
        }
        return res;
    }
    public static void select(int[] nums, int start, List<Integer> path, int n){
        if(path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }
        if(n - path.size() > nums.length - start){
            return;
        }
        for(int i = start; i < nums.length; i++){
            while(i > start && i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
            if(i == nums.length){
                return;
            }
            path.add(nums[i]);
            select(nums, i + 1, path, n);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 1}));
    }
}
