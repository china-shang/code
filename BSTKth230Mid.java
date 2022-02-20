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
class BSTKth230Mid {
    private static int th;
    public int kthSmallest(TreeNode root, int k) {
        th = k;
        return dfs(root) ;
    }
    // 进行dfs，从小到大遍历,即left,root,right,当前遍历前，更小的都被遍历了
    // 每次遍历到当前时,--th,如果th==0,说明找到结果，之后返回结果不再遍历
    public Integer dfs(TreeNode root){
        if(root == null){
            return null;
        }
        Integer res = dfs(root.left);
        if(res != null){
            return res;
        }
        if(--th==0){
            return root.val;
        }
        return dfs(root.right);
    }
}
