import java.util.Deque;
import java.util.LinkedList;

class Eval150Mid {
    // 使用栈计算,遇到数字压栈,遇到符号,弹出数字进行运算,把结果压栈
    // 最后剩下的就是结果
    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < tokens.length; i++){
            if(isNumber(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                int a = stack.pop();
                int b= stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static boolean isNumber(String s){
        return !("-".equals(s) || "+".equals(s) || "*".equals(s) || "/".equals(s));
    }
    public static void main(String[] args) {
        // 22
        System.out.println(evalRPN(new String[]{ "10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
