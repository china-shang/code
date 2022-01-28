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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }

        map = new HashMap<>();
        for(int i = 0;i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length);
    }
    public TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2){
        if(l1 > r1){
            return null;
        }
        int mid = map.get(postorder[r2]);
        int rightLen = r1 - mid;
        TreeNode root = new TreeNode(postorder[r2]);
        root.right = buildTree(inorder, mid + 1, r1, postorder, r2 - rightLen,r2 - 1);
        root.left = buildTree(inorder, l1, mid - 1, postorder, l2, r2-rightLen-1);

        return root;
    }
}
