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

class TreePathSum112 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return targetSum == 0;
        }
        int newTarget = targetSum - root.val;
        return newTarget ==0 && root.left == null && root.right == null || hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
    public static void main(String[] args) {
        System.out.println(hasPathSum(new TreeNode(3, new TreeNode(4, new TreeNode(5, null, null), null), null), 12));
    }
}
