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

class TwoTreeBalance110 {
    // 任意两个左右子树高度相差小于2,=>所有节点都符合左右子树相差小于1=>首先root节点的k子树高度相差小于等于1,并且左右子树也符合这个条件
    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0 ;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(3)), new TreeNode(4));
        System.out.println(isBalanced(t));

    }
}
