import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class CombSum40Mid {
    public static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        res = new ArrayList<>();

        combinationSum2(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public static void combinationSum2(int[] candidates, int target, List<Integer> path, int start){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i = start; i < candidates.length; i++){
            while(i > start && i < candidates.length && candidates[i] == candidates[i-1]){
                i++;
            }
            if(i == candidates.length || candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], path, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // [1,1,6],
        // [1,2,5],
        // [1,7],
        // [2,6]
        // ]
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));

    }
}
