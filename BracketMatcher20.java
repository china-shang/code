import java.util.Stack;

class BracketMatcher20 {

    public static boolean match(String s){
        Stack<Character> stk = new Stack<>();
        for(Character c : s.toCharArray())
            // 如果c是 ({[ 则入栈¬
            if(c == '(' || c == '{' || c == '[' )
                stk.push(c);
            // 如果c是 )}] 并且栈不为空 则 判断栈顶是否为与之对应的左括号 是则出栈，不是则返回fasle
            else if(c == ')' && !stk.empty() && stk.peek() == '(') {
                stk.pop();
            } else if(c == '}' && !stk.empty() && stk.peek() == '{') {
                  stk.pop();
            } else if(c == ']' && !stk.empty() && stk.peek() == '[') {
                  stk.pop();
            }else {
                // 如果c是 )}] 栈为空 那么返回false
                // 如果c是 )}] 栈不为空， 但是 栈顶不是与c对应的左括号 那么返回false
                return false;
            }
        // 例如"(){}[" ， 如果最后栈不为空，那么就是有多余的左括号了
        return stk.empty();
    }

    public static boolean match1(String s){
        Stack<Character> stk = new Stack<>();
        for(Character c : s.toCharArray()){
            // 如果c是 ({[ 则入栈¬
            if(c == '(' || c == '{' || c == '[' )
                stk.push(c);
            // 如果c是 )}] 并且栈不为空 则 判断栈顶是否为与之对应的左括号 是则出栈，不是则返回fasle
            if(c == ')' && (stk.empty() || stk.pop() != '(')) {
                return false;
            }
            if(c == ']' && (stk.empty() || stk.pop() != '[')) {
                return false;
            }
            if(c == '}' && (stk.empty() || stk.pop() != '{')) {
                return false;
            }
        }
        // 例如"(){}[" ， 如果最后栈不为空，那么就是有多余的左括号了
        return stk.empty();
    }

    public static void main(String[] args) {

        System.out.println(match1("[[({})]]"));
        System.out.println(match1("[[({})]][]"));

        System.out.println(match1("[[({})]]]"));
    }
}
