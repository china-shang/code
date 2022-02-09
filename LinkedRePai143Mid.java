import java.util.LinkedList;
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
class LinkedRePai143Mid {
    // 循环开始保证都是指向开头,然后统一处理
    // 最后t.next = null
    public static void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        while(head != null){
            list.offerLast(head);
            head = head.next;
        }
        ListNode t = list.pollFirst();
        while(!list.isEmpty()){
            t.next = list.pollLast();
            t = t.next;
            if(!list.isEmpty()){
                t.next = list.pollFirst();
                t = t.next;
            }
        }
        t.next = null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(head);
        System.out.println(head);
    }
}
