import java.util.List;
import java.util.Deque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

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
class Offer32LevelOrder1 {
    public static int[] levelOrder(TreeNode root){

        if(root == null){
            return new int[0];
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for(int i = 0; i < list.size(); i++){
            TreeNode t = list.get(i);
            if(t.left != null){
                list.add(t.left);
            }
            if(t.right != null){
                list.add(t.right);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i).val;
        }

        return res;
    }
    public static void main(String[] args) {
        // 1, 2 3, 4 5, 6
        System.out.println(Arrays.toString(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(6), null), new TreeNode(5, null,null)), new TreeNode(3)))));

    }
}
