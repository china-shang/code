import java.util.List;
import java.util.ArrayList;

  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Offer68TwoTreeCommonAncestor {
    public static TreeNode ans;
    // 二叉树同时找两个节点,使用静态变量传递值.
    // 找到的标识为,左右都找到了,或者左右找到了一个,并且自身也是一个
    // dfs找到一个就算true 即left || right || root.val = p || root.val == q
    // 二叉树dfs每次有三个需要处理,root left right
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        dfs(root, p.val, q.val);
        return ans;
    }
    public static boolean dfs(TreeNode root, int p, int q){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if(left && right || ((left || right) && (root.val == p || root.val == q))){
            ans = root;
        }

        return left || right || root.val == p || root.val == q;
    }

    // 找到p q 的path 然后求公共值
    // dfs 先序遍历,先加path判断当前是否p q, 然后分别判断left right是否存在p q:使用 || 来执行找到后不继续dfs, 未找到移除path
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1 = new ArrayList<>();
        dfs(root, p.val, p1);
        List<TreeNode> p2 = new ArrayList<>();
        dfs(root, q.val, p2);
        TreeNode ans = root;

        for(int i = 0; i < Math.min(p1.size(), p2.size()); i++){
            if(p1.get(i) == p2.get(i)){
                ans = p1.get(i);
            } else {
                return ans;
            }
        }
        return ans;

    }
    public static boolean dfs(TreeNode root, int target, List<TreeNode> list){
        if(root == null){
            return false;
        }
        list.add(root);
        if(root.val == target){
            return true;
        }
        boolean success = dfs(root.left, target, list) || dfs(root.right, target, list);
        if(success){
            return success;
        }
        list.remove(list.size() - 1);
        return false;

    }
}
