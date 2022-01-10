import java.util.Map;
import java.util.HashMap;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Offer07BuildTreeMid {
    private static Map<Integer, Integer> map;
    // 构造找到root.val,构造root节点,然后root.left = buildTree(左半段) root.right = buildTree(右半段)
    // 通过inorder找到左右子树的数目,分别拆分preorder, inorder
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = map.get(preorder[0]);
        root.left = buildTree(preorder, 1, mid, inorder, 0, mid - 1);
        root.right = buildTree(preorder, mid + 1, preorder.length - 1, inorder, mid + 1, inorder.length - 1);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int l, int r,int[] inorder, int l1, int r1){
        System.out.printf("%d %d\n", l, r);
        if(l > r){
            return null;
        }
        if( l == r){
            return new TreeNode(preorder[l]);
        }
        int mid = map.get(preorder[l]);
        TreeNode root = new TreeNode(preorder[l]);

        root.left = buildTree(preorder, l + 1, l + mid - l1, inorder, l1, mid - 1);
        root.right = buildTree(preorder, l + mid - l1 + 1, r, inorder, mid + 1, r1);
        return root;
    }
    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

    }
}
