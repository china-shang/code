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
class IsValidBST98Mid {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    // BST 作为root首先>left <right,然后作为子树,必须有一个上下限制要求,作为左子树,小于最近的root,作为右子树,大于最近的root
    // 有一个继承下来的left, right作为限制,同时更新为最新的限制
    public static boolean isValidBST(TreeNode root, Integer left, Integer right){
        if(root == null){
            return true;
        }
        if(left != null && root.val <= left || right !=null && root.val >= right){
            return false;
        }
        return (root.left == null ? true : root.left.val < root.val)
            && (root.right==null ? true: root.right.val > root.val) &&
            isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }
    public static void main(String[] args) {
        System.out.println(
                isValidBST(new TreeNode(5,
                        new TreeNode(2,
                            new TreeNode(1),
                            new TreeNode(3)
                                ),
                        new TreeNode(7 ,
                            new TreeNode(6),
                            new TreeNode(9)
                            )
                        )));

        System.out.println(
                isValidBST(new TreeNode(5,
                        new TreeNode(2,
                            new TreeNode(1),
                            new TreeNode(7)
                                ),
                        new TreeNode(7 ,
                            new TreeNode(6),
                            new TreeNode(9)
                            )
                        )));
    }
}
