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

class LinkedInsertSort147Mid {
    // 前后两个指针都是取pre,
    // 前面由于比它小,需要插入在前面,
    // 后面需要把插入节点的前节点指向插入节点下一个节点
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode t = head;
        while(t.next != null){
            ListNode t1 = newHead;
            while(t1 != t){
                if(t.next.val <= t1.next.val){
                    ListNode next = t.next.next;
                    t.next.next = t1.next;
                    t1.next = t.next;
                    t.next = next;
                    break;
                }
                t1 = t1.next;
            }
            if(t1 == t){
                t = t.next;
            }
        }

        return newHead.next;
    }
    public static void main(String[] args) {
        System.out.println(insertionSortList(new ListNode(5, new ListNode(3, new ListNode(6, new ListNode(1))))));
    }
}
