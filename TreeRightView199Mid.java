import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
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

class TreeRightView199Mid {
    // 右视图，只能看到每层的最右边一个节点
    // 使用层序遍历，遇到每层的最后一个节点，添加到res
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            for(int i = q.size(); i > 0; i--){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                if(i == 1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
