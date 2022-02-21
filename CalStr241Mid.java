import java.util.List;
import java.util.ArrayList;

class CalStr241Mid{
    // dfs或者叫分治, 如果每次选择优先级最高的计算，需要把结果插回str
    // 如果每次选择优先级最低的，递归求解左右两部分，然后对于所有的left结果和right进行计算，得到结果
    public static List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression, 0, expression.length()-1);
    }
    public static List<Integer> dfs(String expression, int l, int r){
        List<Integer> res = new ArrayList<>();
        boolean isNum = true;
        int num = 0;
        for(int i = l; i <= r; i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            } else {
                isNum = false;
                List<Integer> left = dfs(expression, l, i-1);
                List<Integer> right = dfs(expression, i+1, r);
                for(int t1: left){
                    for(int t2: right){
                        switch(c){
                            case '+':
                                res.add(t1 + t2);break;
                            case '-':
                                res.add(t1 - t2);break;
                            case '*':
                                res.add(t1 * t2);break;
                        }
                    }
                }
            }
        }
        if(isNum){
            res.add(num);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("1+2-3*4-1+2"));
    }
}
