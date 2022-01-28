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
         return String.valueOf(left) + " " + val + " " + String.valueOf(right);
     }
 }
class ArrayToBST108Mid {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        int mid = (r - l >> 1) + l;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{1,2,3,4,5,6,7}));
    }
}
