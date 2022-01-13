 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     public String toString(){
         return val + "->" + String.valueOf(next);
     }
 }

class LinkRemoveKth19Mid {
    // 先处理特殊情况,n >= length,先走n步,如果quick==null,如果n==0,移除头,否则不移除.
    // 如果接下来使用快慢指针,quick=null,移除的节点就是slow,需要slow.before才能进行移除
    // 所以quick再走一步,此时slow.next为待移除节点,slow.next=slow.next.next
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // length 走length , == null n == 0 return head.next
        // length 走length , == null n > 0 return head
        // length 走length , != null n > 0, 再走一步
        ListNode slow = head, quick = head;
        while(n > 0 && quick != null){
            quick = quick.next;
            n--;
        }
        if(quick == null){
            if(n == 0){
                return head.next;
            }else{
                return head;
            }
        }
        quick = quick.next;
        while(quick != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        // 1 2 3 4
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1));
        // 2 3 4 5
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5));

        // 1 2 3 4 5
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 6));

    }
}
