import java.util.Set;
import java.util.HashSet;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

     ListNode(int x, ListNode next) {
         this.val = x;
         this.next = next;
     }
     public String toString(){
         return String.valueOf(val) + String.valueOf(next);
     }
 }
public class InterLink160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        Set<ListNode> set = new HashSet<>();
        while(cur!=null){
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        System.out.println(set);
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }

        return cur;
    }

    public static void main(String[] args) {
        ListNode same = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode n1 = new ListNode(3, new ListNode(4, same));
        ListNode n2 = new ListNode(1, new ListNode(4, same));
        System.out.println(getIntersectionNode(n1, n2));

    }
}
