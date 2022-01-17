import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class CombSum39Mid {
    public static List<List<Integer>> res;
    // 分步,选择,使用回溯法.不过每次的选择有限制,必须大于等于最后选择的下标
    // 排序后,遇到大于target的数字,就能直接停止了
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>());

        return res;
    }

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    public static void combinationSum(int[] candidates, int target, List<Integer> path, int start){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i = start; i < candidates.length ; i++){
            if(candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }

    public static void combinationSum(int[] candidates, int target, List<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0; i < candidates.length ; i++){
            if(candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        //  [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum1(new int[]{2,3,5}, 8));

    }
}
