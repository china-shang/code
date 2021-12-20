 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class TwoTreeLowestCommonAncestor235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while(true){
            if(ans.val > p.val && ans.val > q.val){
                ans = ans.left;
            }else if(ans.val < p.val && ans.val <q.val){
                ans = ans.right;
            }else{
                break;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
    }
}
