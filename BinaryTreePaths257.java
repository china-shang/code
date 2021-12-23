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
class BinaryTreePaths257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        return binaryTreePaths(root, "", list);
    }
    public static List<String> binaryTreePaths(TreeNode root, String path, List<String> list) {
        if(path.isEmpty()){
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }
        if(root.left == null && root.right == null){
            list.add(path);
            return list;
        }
        if(root.left != null){
            binaryTreePaths(root.left, path, list);
        }
        if(root.right != null){
            binaryTreePaths(root.right, path, list);
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(binaryTreePaths(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))));
    }
}
