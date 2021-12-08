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

public class TwoTreeHigh104 {
    // 高度等于最高的子树+1
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(4), new TreeNode(5)), new TreeNode(3)), new TreeNode(4));
        System.out.println(maxDepth(t));
    }
}
