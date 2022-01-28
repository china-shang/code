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
class GenTwoTree95Mid {
    private static List<TreeNode> res;
    // 易想到,遍历作为root, 然后left=gen(l,r) right=gen(l,)
    // 但是左右子树同样有n个选择,同时同样有左右n个子树的组合,所以,左右子树都是列表
    // 左右子树进行迪卡尔积组合成当前的所有树
    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    public static  List<TreeNode> generateTrees(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        if(l > r){
            res.add(null);
            return res;
        }

        for(int i = l; i <= r; i++){
            List<TreeNode> lefts = generateTrees(l, i-1);
            List<TreeNode> rights = generateTrees(i+1, r);
            for(TreeNode left: lefts){
                for(TreeNode right: rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
