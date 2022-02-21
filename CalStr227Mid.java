import java.util.LinkedList;
import java.util.Deque;

class CalStr227Mid{
    // 先计算*/如果是-，替换为+,操作数后进先出，使用栈，结果压入栈,在栈中计算+
    // 把op为+的数入栈,如果op=*/,需要计算后入栈，弹栈计算后入栈,保证栈中都是加数
    // 读取完一个数时即遇到字符串结尾或遇到下一个op,根据前一个op决定操作,并压入栈,开始op为+
    public static int calculate(String s) {
        Deque<Integer> st = new LinkedList<>();

        char op = '+';
        for(int i = 0, num=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1){
                switch(op){
                    case '+': st.push(num); break;
                    case '-': st.push(-num); break;
                    case '*': st.push(num * st.pop()); break;
                    case '/': st.push(st.pop() / num); break;
                }
                op = c;
                num = 0;
            }
        }

        int res = 0;
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
       System.out.println(calculate("1 * 234 - 324  / 324 + 3 -4"));
    }
}
