class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class LinkedNumberAdd21 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode t = head;
        int flag = 0;
        while(l1 != null || l2 != null){
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 :l2.val) + flag;
            t.next = new ListNode((val)% 10);
            if(val >= 10){
                flag = 1;
            }else{
                flag = 0;
            }
            t = t.next;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        if(flag == 1){
            t.next = new ListNode(1);
        }

        return head.next;
    }

    public static void print(ListNode l){

        while(l != null){
            System.out.print(l.val);
            l = l.next;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(2, new ListNode(7, new ListNode(8, null)));

        print(addTwoNumbers(l1 ,l2));
    }

}
