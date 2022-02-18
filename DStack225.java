import java.util.Deque;
import java.util.LinkedList;

class DStack225 {
    // 使用队列来实现栈，复杂度达不到O(1)
    // 新元素插入到队尾后，每次都把前面的所有元素依次从队首移动到尾部
    Deque<Integer> q  = new LinkedList<>();
    public DStack225() {

    }

    public void push(int x) {
        int n = q.size();
        q.offer(x);
        for(int i = 0 ; i < n; i++){
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        DStack225 st = new DStack225();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
