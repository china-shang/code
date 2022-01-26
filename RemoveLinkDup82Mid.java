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
class RemoveLinkDup82Mid {
    // 由于需要移除所有重复的,使用next和next.next作为判断
    // while 判空,如果next.val == next.next.val 保存next.val,然后while next 判空,并且=x时,跳过next
    // 否则t = next
    public static ListNode deleteDuplicates1(ListNode head) {
        if(head == null){
            return null;
        }
        head = new ListNode(-1, head);
        ListNode t = head;
        while(t.next != null && t.next.next != null){
            if(t.next.val == t.next.next.val){
                int x = t.next.val;
                while(t.next != null && t.next.val == x){
                    t.next = t.next.next;
                }
            } else {
                t = t.next;
            }
        }

        return head.next;
    }
    // 往前追加一个node,防止第一个node被移除
    // 终止条件为t != null 因为t.next 为null也能正确处理,
    // 并且t可能为null,所以t!=null必定需要,
    // 加上t.next!=null也只是白加而已,只是减少一轮判断
    // 但t.next 内部要求非空,并且t必定不为null,才单独加t.next != null
    // 循环套循环,提取方法,
    // 链表的空判断,使用到了val,必定要求非空
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        head = new ListNode(-1, head);
        ListNode t = head;
        while(t != null){
            t.next = nextNode(t.next);
            t = t.next;
        }
        return head.next;
    }

    public static ListNode nextNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow =head, quick = head.next;
        while(quick != null && slow.val == quick.val){
            do {
                quick = quick.next;
            } while(quick != null && slow.val == quick.val);
            if(quick == null){
                return null;
            }
            slow = quick;
            quick = quick.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        // null
        System.out.println(deleteDuplicates(new  ListNode(1, new ListNode(1))));
        System.out.println(deleteDuplicates1(new  ListNode(1, new ListNode(1))));

        // 2 3
        System.out.println(deleteDuplicates(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        System.out.println(deleteDuplicates1(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));

        // 2 3
        System.out.println(deleteDuplicates(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        System.out.println(deleteDuplicates1(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));

        // 2 3
        System.out.println(deleteDuplicates(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))))));
        System.out.println(deleteDuplicates1(new  ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))))));
    }

}
