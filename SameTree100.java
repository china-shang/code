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
public class SameTree100 {
    // 根节点相等，左右子树分别相等
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null){
            return true;
        }
        if(q==null || p==null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(4), new TreeNode(5, new TreeNode(3), null));
        System.out.println(isSameTree(tree, tree));

    }
}
