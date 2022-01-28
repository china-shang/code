import java.util.List;
import java.util.ArrayList;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

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
class LinkToBST109Mid {
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBST(list, 0, list.size() - 1);
    }
    public static TreeNode sortedListToBST(List<Integer> list, int l, int r){
        if(l > r){
            return null;
        }
        int mid = (r - l >> 1) + l;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBST(list, l, mid - 1);
        root.right = sortedListToBST(list, mid + 1, r);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(sortedListToBST(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(7,new ListNode(8))))))));
    }
}
