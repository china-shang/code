 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      ListNode(int x, ListNode next) { val = x;this.next = next; }
      public String toString(){
          return val + "," + String.valueOf(next);
      }
  }

class Offer25MergeSortedLink {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode a = head.next, b = head == l1 ? l2 : l1, t=head;
        while(a != null && b != null){
            if(a.val < b.val){
                t.next = a;
                a = a.next;
            } else {
                t.next = b;
                b = b.next;
            }
            t = t.next;
        }
        t.next = a == null ? b : a;
        return head;
    }

    public static void main(String[] args) {

        // 1 2 3 4 5 6
        System.out.println(mergeTwoLists(new ListNode(1, new ListNode(3, new ListNode(5))), new ListNode(2, new ListNode(4, new ListNode(6)))));

    }
}
