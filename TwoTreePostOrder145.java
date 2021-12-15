import java.util.List;
import java.util.ArrayList;
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
class TwoTreePostOrder145 {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        System.out.println(postorderTraversal(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

    }
}
