import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
     }
 }
class LevelOrder107Mid {
    public static List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        LinkedList<List<Integer>> res = new LinkedList<>();
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = q.size(); i > 0;i--){
                TreeNode t = q.poll();
                list.add(t.val);
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
            }
            res.offerFirst(list);
        }


        return res;
    }
    public static void main(String[] args) {
        // 6 4 5 2 3 1
        System.out.println(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(6), null), new TreeNode(5, null,null)), new TreeNode(3))));

    }
}
