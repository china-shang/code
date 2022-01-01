 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class TwoTreeIsSubStructureOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        return isSectionSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }
    public boolean isSectionSame(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A == null){
            return false;
        }
        return A.val == B.val && isSectionSame(A.left, B.left) && isSectionSame(A.right, B.right);
    }
    public static void main(String[] args) {

    }
}
