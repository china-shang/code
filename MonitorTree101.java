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

class MonitorTree101 {
    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    // 对称：根节点相等，左子树和右子树对称，右子树和左子树对称
    public static boolean check(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }
        return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }

    public static void main(String[] args) {

    }
}
