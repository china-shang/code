import java.util.List;
import java.util.ArrayList;
class SubSet78Mid{
    private static List<List<Integer>> res;

    // 需要所有的子集所以,必定需要遍历所有可能
    // 遍历时,固定前n个数字,然后遍历后面的数字
    // 固定1,遍历2->n-1,固定1,2,遍历3->n-1...
    // 每次遍历的时候不能选择前面的数字,因为他们已经便利过了
    // 使用k表示还需要几个数字,使用end表示已经拿到几了,使用path保存路径
    // end + k 表示至少需要的数字,如果>nums.length - 1,直接return
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            select(nums, i, -1, new ArrayList<>());
        }
        return res;
    }
    public static void select(int[] nums, int k, int end, List<Integer> path){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(end + k > nums.length - 1){
            return;
        }
        for(int i = end + 1; i < nums.length;i++){
            path.add(nums[i]);
            select(nums, k-1, i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3, 4}));

    }
}
