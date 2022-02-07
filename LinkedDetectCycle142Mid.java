import java.util.Set;
import java.util.HashSet;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     ListNode(int x, ListNode _next) {
         val = x;
         next = _next;
     }
     public String toString(){
         return String.valueOf(val);
     }
 }
class LinkedDetectCycle142Mid{
    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        node.next.next.next = node.next;
        System.out.println(detectCycle(node));
    }
}
