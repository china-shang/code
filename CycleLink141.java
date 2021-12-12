 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
     ListNode(int x, ListNode next) {
         val = x;
         this.next = next;
     }
 }

public class CycleLink141 {
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode one =head, two=head.next;;
        while(two != null && two != one){
            one = one.next;
            if(two.next != null){
                two = two.next.next;
            } else {
                two = null;
            }
        }
        return one == two;
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(4);
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, tail)));
        System.out.println(hasCycle(n1));

        tail.next = n1.next;
        System.out.println(hasCycle(n1));

    }
}
