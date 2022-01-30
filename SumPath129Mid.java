import java.util.List;
import java.util.ArrayList;

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
class SumPath129Mid {
    // root的path和=左右子树的path和,遇到叶子节点计算sum,如果null节点=0
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumNumbers(root, new ArrayList<>());
    }
    public static int sumNumbers(TreeNode root, List<Integer> path){
        if(root == null){
            return 0 ;
        }
        if(root.left == null && root.right == null){
            int num = 0;
            for(int i = 0; i < path.size(); i++){
                num = num * 10 + path.get(i);
            }
            return num * 10 + root.val;
        }

        path.add(root.val);
        int num = sumNumbers(root.left, path) + sumNumbers(root.right, path);
        path.remove(path.size() -1 );
        return num;
    }
}
