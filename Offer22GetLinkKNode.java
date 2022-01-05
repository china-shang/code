 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode(int x, ListNode next) { val = x;this.next = next; }

     public String toString(){
         return val + "," + String.valueOf(next);
     }
 }

class Offer22GetLinkKNode {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode a = head, b=head;
        while(k-- > 0){
            b = b.next;
            if(b == null && k > 0){
                return null;
            }
        }
        while(b != null){
            a = a.next;
            b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        // 2
        System.out.println(getKthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))), 4));

        // 1
        System.out.println(getKthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))), 5));
        //
        // null
        System.out.println(getKthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))), 6));
    }

}
