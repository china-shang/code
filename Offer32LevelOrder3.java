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
class Offer32LevelOrder3 {
    public static List<List<Integer>> levelOrder1(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<>();
            // 初始化i=q.size(),因为q.size()一直在变，不能放在判断里
            for(int i = q.size(); i > 0; i--){
                TreeNode t = q.poll();
                if((list.size() & 1) == 0){
                    tmp.offerLast(t.val);
                }else{
                    tmp.offerFirst(t.val);
                }
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
            }
            list.add(tmp);
        }

        return list;
    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode>[] ts = new Deque[]{ new LinkedList<>(), new LinkedList<>()};
        ts[0].push(root);
        List<List<Integer>> list = new ArrayList<>();
        while(!ts[0].isEmpty() || !ts[1].isEmpty()){
            int size = list.size();
            List<Integer> nowList = new ArrayList<>();
            for(int i = ts[size & 1].size(); i > 0; i--){
                TreeNode t = ts[size & 1].pop();
                nowList.add(t.val);
                if((size & 1) == 0){
                    if(t.left != null){
                        ts[(size+1)&1].push(t.left);
                    }
                    if(t.right != null){
                        ts[(size+1) & 1].push(t.right);
                    }
                } else {
                    if(t.right != null){
                        ts[(size+1) & 1].push(t.right);
                    }
                    if(t.left != null){
                        ts[(size+1)&1].push(t.left);
                    }
                }
            }
            list.add(nowList);
        }
        return list;
    }
    public static void main(String[] args) {
        // 1,3 2, 4 5, 6
        System.out.println(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(7)), new TreeNode(5, new TreeNode(8),null)), new TreeNode(3))));
        System.out.println(levelOrder1(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(7)), new TreeNode(5, new TreeNode(8),null)), new TreeNode(3))));

    }
}
