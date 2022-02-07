import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public String toString(){
        Node head = this;
        String s = "";
        while(head != null){
            s += head.val;
            s += ",random=" + (head.random == null ? null : head.random.val);
            s += ",next=" + (head.next == null ? null : head.next.val + ";   ");
            head = head.next;
        }
        return s;
    }
}
class Offer35CopyRandomList {
    public static Node copyRandomList1(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node last = newHead;
        Node t = head.next;
        while(t != null){
            last.next = new Node(t.val);
            last = last.next;
            map.put(t, last);
            t = t.next;
        }

        last = newHead;
        while(head != null){
            last.random = map.get(head.random);
            last = last.next;
            head = head.next;
        }

        return newHead;
    }
    //
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node, Integer> nodeToIdx = new HashMap<>();
        List<Node> idxToNode = new ArrayList<>();
        Node t = head;
        Node newNode = null;
        for(int i = 0 ; head != null; i++){
            nodeToIdx.put(head, i);

            if(newNode != null){
                newNode.next = new Node(head.val);
                newNode = newNode.next;
            } else {
                newNode = new Node(head.val);
            }
            idxToNode.add(newNode);
            head = head.next;
        }

        for(int i = 0; t != null; i++){
            if(t.random != null){
                idxToNode.get(i).random = idxToNode.get(nodeToIdx.get(t.random));
            }
            t = t.next;
        }
        return idxToNode.get(0);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n4;
        n2.random = n2;
        n3.random = n1;
        n4.random = n3;

        System.out.println(n1);
        System.out.println(copyRandomList(n1));
        System.out.println(copyRandomList1(n1));

    }
}
