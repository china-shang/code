import java.util.LinkedList;
import java.util.Deque;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class ConnectNode117Mid {
    // 层序遍历,当前层剩余数量大于1,修改next指向队列首
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            for(int i = q.size(); i>=1; i--){
                Node t = q.poll();
                if(t.left != null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
                if(i > 1){
                    t.next = q.peek();
                } else {
                    t.next = null;
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
