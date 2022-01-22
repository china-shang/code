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
class RotateLink61Mid {
    // 1设长度为n, 首先考虑k<=n-1的情况,因为之后k>=n可以转换为n-1内
    // 2如果quick = null, slow.before就是tail, slow就是newHead,但是无法拿到slow.before
    // 3 所以quick.next = null停止,此时tail=slow newHead=slow.next quick.next = head
    // 4然后考虑所有的k,先走k步或者quick=null,如果quick!=null,说明k<n,不处理,走3
    // 5如果quick==null, k = k % n,得到新的k,然后quick走k步,此时最多走到tail
    // 6然后slow=slow.next,quick=quick.next while quick.next != null,停止时走3
    // 链表从head走到null 要n步:虽然head没走,但是走到了null
    // head走到tail,要n-1步
    public static ListNode rotateRight(ListNode head, int k) {
        // 如果能简单排除特例,直接前置排除
        if(head == null || k == 0){
            return head;
        }
        ListNode slow = head, quick = head;
        int n = 0;
        while(k > 0 && quick != null){
            quick = quick.next;
            k--;
            n++;
        }
        if(quick  == null){
            k = k % n;
            if(k == 0){
                return head;
            }
            quick = head;
            while(k-- > 0){
                quick = quick.next;
            }
        }

        while(quick.next != null){
            slow = slow.next;
            quick = quick.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        quick.next = head;

        return newHead;
    }
    public static void main(String[] args) {
        // 4 5 1 2 3
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        // 1 2 3 4 5
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5));
        // 5 1 2 3 4
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 6));
    }
}
