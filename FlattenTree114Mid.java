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
     public String toString(){
         return val + "->" + String.valueOf(right);
     }
 }
class FlattenTree114Mid {
    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten1(root);
        root.left = null;
    }
    // 使用left指针指向尾部,形成环. 需要分别考虑left,right为空共4种情况,最后返回前把root.left=null
    public static TreeNode flatten1(TreeNode root){
        if(root == null){
            return null;
        }
        //
        TreeNode head =  root;
        TreeNode left = flatten1(root.left);
        TreeNode right = flatten1(root.right);
        if(left != null){
            root.right = left;
            left.left.right = right;
            if(right != null){
                root.left = right.left;
                right.left = null;
            } else{
                root.left = left.left;
            }
            left.left = null;
        } else {
            root.right = right;
            if(right != null){
                root.left = right.left;
                right.left = null;
            } else {
                root.left = root;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                            new TreeNode(3,
                                new TreeNode(1),
                                new TreeNode(4)
                                ),
                            new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7)
                                )
                );
        flatten(root);
        System.out.println(root);
    }
}
