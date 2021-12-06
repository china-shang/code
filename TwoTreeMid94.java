import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
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
class TwoTreeMid94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return Collections.emptyList();
        }
;       List<Integer> l = new ArrayList<>();
        inorderTraversal(root, l);
        return l;
    }
    public static void inorderTraversal(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal(new TreeNode(2, new TreeNode(1), new TreeNode(3))));


    }
}
