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
class TwoTreePreOrder144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public static void preorderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        System.out.println(preorderTraversal(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

    }
}
