 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class LinkedRemove237{
    public static void deleteNode(ListNode node) {
        // 1 2 3 >4 5 6
        node.val = node.next.val;
        while(node.next.next != null){
            node.next.val = node.next.next.val;
            node = node.next;
        }
        node.next = null;
    }
    public static void deleteNode1(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
