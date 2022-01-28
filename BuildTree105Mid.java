import java.util.Map;
import java.util.HashMap;
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
class BuildTree105Mid {
    private static Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }

        map = new HashMap<>();
        for(int i = 0;i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2){
        if(l1 > r1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int mid = map.get(preorder[l1]);
        int leftLen = mid - l2;
        root.left = buildTree(preorder, l1 + 1, l1 + leftLen, inorder, l2, mid - 1);
        root.right = buildTree(preorder, l1 + leftLen + 1, r1, inorder, mid + 1, r2);
        return root;
    }
}
