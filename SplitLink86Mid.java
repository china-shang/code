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
class SplitLink86Mid {
    // head前插入一个节点,防止移动到head前
    // 找到>=x的node1,然后把之后小于x的节点插入到node1前
    // 由于需要插入到node1前,所以使用next来判断比较,
    // 之后由于需要在后段移除较小的node,所以使用next来比较
    // 找到较小的node后,前段.next=node, 前段=next. 然后t.next = t.next.next移除节点
    // 最后前段.next=node1
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode headBefore = new ListNode(-1, head);
        ListNode t = headBefore;
        while(t.next != null && t.next.val < x){
            t = t.next;
        }
        if(t.next == null){
            return head;
        }
        ListNode last = t.next, xNode = t.next;
        while(last.next != null){
            if(last.next.val < x){
                t.next = last.next;
                t = t.next;
                last.next = last.next.next;
            } else {
                last = last.next;
            }
        }
        t.next = xNode;

        return headBefore.next;
    }
    public static void main(String[] args) {
        // 1 2 2 1 3 5
        System.out.println(partition(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(5)))))), 3));
        // 1 2 1 4 3 5
        System.out.println(partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(5)))))), 3));
        //
        // 2 1
        System.out.println(partition(new ListNode(2, new ListNode(1)), 2));
    }
}
