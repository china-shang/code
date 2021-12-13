import java.util.Deque;
import java.util.LinkedList;
class Node {
    public int min;
    public int val;
    public Node next;

    public Node(int val, int min){
        this.val = val;
        this.min = min;
    }

    public Node(int val, int min, Node head){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
class MinStack {
    private Node head;

    public void push(int val) {
        if(head == null){
            head = new Node(val, val);
        }
        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}

public class MinStack155 {
    private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();

    public MinStack155() {

        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
    public static void main(String[] args) {
        MinStack155 obj = new MinStack155();
        obj.push(21);
        obj.push(19);
        obj.push(20);
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(obj.getMin());

        MinStack st = new MinStack();
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.getMin());

        System.out.println(st.top());

    }
}
