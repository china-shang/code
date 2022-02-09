import java.util.Map;
import java.util.HashMap;

class Node{
    public Node pre;
    public Node next;
    public int val;
    public int key;
    public Node(int _val, int _key){
        this.key = _key;
        this.val = _val;
    }
}
// 使用头尾两个节点包围有效节点,添加节点往tail前添加,删除节点往head后删除
// head tail始终不变. 抽象两个操作1.移除节点,2添加节点到tail前
// 访问到节点时先移除再添加到末尾,节点满时移除head.next
class LRUCache2 {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache2(int capacity){
        map = new HashMap<>();
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next= tail;
        tail.pre = head;
   }
   public int get(int key){
       Node node = map.get(key);
       if(node == null){
           return -1;
       }
       removeNode(node);
       addToTail(node);
       return node.val;
   }
   public void put(int key, int value){
       if(map.containsKey(key)){
           Node node = map.get(key);
           node.val = value;

           removeNode(node);
           addToTail(node);
           return;
       }
       if(cap <= map.size()){
           map.remove(head.next.key);
           removeNode(head.next);
       }
       Node node = new Node(value, key);
       addToTail(node);
       map.put(key, node);
       return;
   }
   public void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
   }
   public void addToTail(Node node){
       node.next = tail;
       node.pre = tail.pre;
       tail.pre.next = node;
       tail.pre = node;
   }
}
class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        if(tail != node){
            if(node != head){
                node.pre.next = node.next;
            } else {
                head = node.next;
            }
            node.next.pre = node.pre;

            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = tail.next;
        }
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            if(tail != node){
                if(node != head){
                    node.pre.next = node.next;
                } else {
                    head = node.next;
                }
                node.next.pre = node.pre;

                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = tail.next;
            }
            return;
        }
        if(map.size() >= cap){
            map.remove(head.key);
            if(head == tail){
                tail = null;
                head = null;
            } else {
                head = head.next;
                head.pre = null;
            }
        }
        Node node = new Node(value, key);
        map.put(key, node);
        node.pre = tail;
        node.next = null;
        if(tail == null){
            head = node;
            tail = node;
        } else{
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);

        // -1
        System.out.println(cache.get(1));
        // 2
        System.out.println(cache.get(2));

        cache.put(5,5);
        // -1
        System.out.println(cache.get(3));

    }
}
