import java.util.Stack;

class StackTest {

    public static void test1(){
        Stack<String> stack = new Stack<>();
        stack.push("a1");
        stack.push("s2");

        String s = stack.peek();
        System.out.println(s);

        s = stack.pop();
        System.out.println(s);
        s = stack.pop();
        System.out.println(s);

        System.out.println(stack.isEmpty());
    }


    public static void main(String[] args) {
        test1();

    }
}
