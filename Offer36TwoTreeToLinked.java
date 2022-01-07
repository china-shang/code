class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    public String toString(){
        return val + "->" + String.valueOf(right);
    }
};
class Offer36TwoTreeToLinked {
    // 执行的过程中,只要使用left指向尾节点,不用使用right指向头节点
    // 最后返回前,指向头节点
    // 树的节点情况分为4种情况分别处理
    // 1.left==null && right ==null root.left = root
    // 2.left !=null && right != null 处理left-root root-right然后left.left = t=right.left,返回left
    // 3.left == null && right !=null 处理root-right 然后root.left = t=right.left,返回root
    // 4.left != null && right == null 处理left-root 然后left.left = root,返回left
    public static Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        root = treeToDoublyList1(root);
        root.left.right = root;
        return root;
    }
    public static Node treeToDoublyList1(Node root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            root.left = root;
            return root;
        }

        Node left = treeToDoublyList1(root.left);
        if(left !=null){
            left.left.right = root;
            root.left = left.left;
        }

        if(root.right != null){
            Node right = treeToDoublyList1(root.right);

            root.right = right;
            Node t = right.left;
            right.left = root;
            if(left == null){
                root.left = t;
            } else {
                left.left = t;
            }
        } else {
            left.left = root;
        }
        if(left != null){
            return left;
        } else {
            return root;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(5,
                        new Node(3,
                            new Node(2),
                            new Node(4)
                            ),
                        new Node(7,
                            new Node(6),
                            new Node(8)
                            )
                        );
        // 2 3 4 5 6 7 8
    Node res = treeToDoublyList(root);
    res.left.right = null;
    System.out.println(res);


    }

}
