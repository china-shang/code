import java.util.LinkedList;
import java.util.Deque;

class MyQueue232 {
    Deque<Integer> st = new LinkedList<>();
    Deque<Integer> st2 = new LinkedList<>();

    public MyQueue232() {

    }

    public void push(int x) {
       while(!st.isEmpty()){
           st2.push(st.pop());
       }
       st.push(x);
       while(!st2.isEmpty()){
           st.push(st2.pop());
       }
    }

    public int pop() {
        return st.pop();
    }
    public int peek() {
        return st.peekFirst();
    }

    public boolean empty() {
        return st.isEmpty();
    }
    public static void main(String[] args) {

    }
}
