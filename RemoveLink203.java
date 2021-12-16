 class ListNode{
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     public String toString(){
         return val +" " + String.valueOf(next);
     }
 }
class RemoveLink203 {
    public static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    public static ListNode removeElements1(ListNode head, int val){
        ListNode first = new ListNode(0, head);
        ListNode cur = first;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return first.next;
    }

    public static void main(String[] args) {
        System.out.println(removeElements(new ListNode(3, new ListNode(4, new ListNode(3, new ListNode(5)))), 3));
        System.out.println(removeElements(new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(3)))), 3));

        System.out.println(removeElements1(new ListNode(3, new ListNode(4, new ListNode(3, new ListNode(5)))), 3));
        System.out.println(removeElements1(new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(3)))), 3));
    }
}
