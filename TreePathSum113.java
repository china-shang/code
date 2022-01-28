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

class TreePathSum113 {
    private static List<List<Integer>> res;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>());
        return res;
    }
    // 如果使用前置root==null作为是否添加到res的判断,left == null, right ==null会重复
    // root==null判断保留,但不处理,然后在方法结尾添加判断是否根节点且符合条件,添加res
    public static void pathSum(TreeNode root, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        targetSum = targetSum - root.val;
        path.add(root.val);
        pathSum(root.left, targetSum, path);
        pathSum(root.right, targetSum, path);
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(3,
                        new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(2,
                                new TreeNode(2), null
                                )
                            ),
                        new TreeNode(4)
                        ), 9));
    }
}
