import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class LinkIsHui234 {
    public static boolean isPalindrome2(ListNode head){
        ListNode slow = head, quick = head.next;
        while(quick != null){
            slow = slow.next;
            quick = quick.next;
            if(quick != null){
                quick = quick.next;
            }
        }
        slow = reverse(slow);
        ListNode t = slow;
        while(t != null){
            if(head.val != t.val){
                return false;
            }
            head = head.next;
            t = t.next;
        }
        reverse(slow);
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static boolean isPalindrome1(ListNode head){
        ListNode slow = head, quick = head.next;
        while(quick != null){
            slow = slow.next;
            quick = quick.next;
            if(quick != null){
                quick = quick.next;
            }
        }
        Deque<Integer> st = new LinkedList<>();
        while(slow != null){
            st.push(slow.val);
            slow = slow.next;
        }
        while(!st.isEmpty() && head != null){
            if(head.val != st.pop()){
                return false;
            }
            head = head.next;
        }
        return true;
    }
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

        System.out.println(isPalindrome1(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(isPalindrome1(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));

        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
    }
}
