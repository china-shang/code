 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class RemoveDuplicatesLink83 {
    public static ListNode remove(ListNode head){
        if(head == null){
            return null;
        }
        ListNode before = head;

        // 持有前一个的指针才能进行删除，before = before.next ,before.next !=null.所以before!=null
        // 移除一个节点时,before 不移动，因为下一个节点也有可能重复，直到没有节点或者不重复before=before.next
        while(before.next != null){
            if(before.val == before.next.val){
                before.next = before.next.next;
            }else{
                before = before.next;
            }
        }
        return head;
    }

    public static void print(ListNode head){
        ListNode node = head.next;
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        print(remove(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1)))))));
    }
}
