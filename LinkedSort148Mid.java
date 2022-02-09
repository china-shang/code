import java.util.ArrayList;
import java.util.List;

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

class LinkedSort148Mid {
    public static ListNode sortList2(ListNode head){
        return sortList(head, null);
    }
    // 归并法排序,使用快慢指针拆分链表,quick = head.next
    // 如果head == tail, head.next=null,后面merge时入参两个链表
    // sort(slow.next, tail)必需在前面,否则slow.next可能变掉
    public static ListNode sortList(ListNode head, ListNode tail){
        if(head == null ){
            return head;
        }
        if(head == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, quick = head.next;
        while(quick != tail){
            slow = slow.next;
            quick = quick.next;
            if(quick != tail){
                quick = quick.next;
            }
        }
        ListNode h2 = sortList(slow.next, tail);
        ListNode h1 = sortList(head, slow);
        return merge(h1, h2);
    }

    public static ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }
        ListNode head = h1.val < h2.val ? h1 : h2;
        ListNode t1 = h1 == head ? h1.next : h1,
                 t2 = h2 == head ? h2.next : h2,
                 t = head;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                t.next = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t2 = t2.next;
            }
            t = t.next;
        }
        if(t1==null){
            t.next = t2;
        } else {
            t.next = t1;
        }
        return head;
    }
    public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        ListNode[] arr = list.toArray(new ListNode[]{});
        sort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length - 1; i++){
            arr[i].next = arr[i+1];
        }
        arr[arr.length - 1].next = null;

        return arr[0];
    }
    public static void sort(ListNode[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int key = arr[r].val, mid = l;
        for(int i = l; i < r; i++){
            if(arr[i].val <= key){
                swap(arr, i, mid++);
            }
        }
        swap(arr, mid, r);
        sort(arr, l, mid-1);
        sort(arr, mid+1, r);
    }
    public static void swap(ListNode[] arr, int l, int r){
        ListNode t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
    public static void main(String[] args) {
        System.out.println(sortList(new ListNode(3, new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(0)))))));
        System.out.println(sortList2(new ListNode(3, new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(0)))))));
    }
}
