 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode(int x, ListNode next) { val = x;this.next = next; }

     public String toString(){
         return val + "," + String.valueOf(next);
     }
 }
class Offer18DeleteLinkedNode {
    public static ListNode deleteNode1(ListNode head, int val) {
        ListNode beforeHead = new ListNode(-1, head);
        head = beforeHead;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return beforeHead.next;
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode oldHead = head;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return oldHead;
    }

    public static void main(String[] args) {
        //  2 3 4
        System.out.println(deleteNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 1));
        // 1 2 3
        System.out.println(deleteNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 4));
        // 1 2 4
        System.out.println(deleteNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 3));

        System.out.println();

        //  2 3 4
        System.out.println(deleteNode1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 1));
        // 1 2 3
        System.out.println(deleteNode1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 4));
        // 1 2 4
        System.out.println(deleteNode1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 3));
    }

 }
