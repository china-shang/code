import java.util.ArrayList;
import java.util.List;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class Offer34TwoTreePathSumMid{
    private static List<List<Integer>> res ;
    private static List<Integer> list ;
    // 使用一个path变量存储路径,遍历完进行回溯,从path中移除node
    // 遇到符合的path,复制path,放入res
    // val可能为负数和0所以只有null return, val = target && left == null && right ==null 添加path
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        res = new ArrayList<>();
        pathSum1(root, target);
        return res;
    }
    public static void pathSum1(TreeNode root, int target){
        if(root == null){
            return ;
        }
        if(root.val == target && root.left == null && root.right == null){
            List<Integer> t = new ArrayList<>(list);
            t.add(root.val);
            res.add(t);
            return ;
        }

        int newTarget = target - root.val;
        list.add(root.val);
        pathSum1(root.left, newTarget);
        pathSum1(root.right, newTarget);
        list.remove(list.size() - 1);
    }
    public static void main(String[] args) {
        // 1 2 2
        // 1 1 3
        System.out.println(pathSum(new TreeNode(1,
                        new TreeNode(2,
                            new TreeNode(2),
                            new TreeNode(3)
                            ),
                        new TreeNode(1,
                            new TreeNode(3),
                            new TreeNode(4)
                            )
                        ), 5));

    }
}
