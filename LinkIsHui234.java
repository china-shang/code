import java.util.List;
import java.util.ArrayList;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class LinkIsHui234 {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            nodes.add(cur.val);
            cur = cur.next;
        }
        for(int i=0,j=nodes.size() - 1; i < j;i++,j--){
            if(nodes.get(i) != nodes.get(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
    }
}
