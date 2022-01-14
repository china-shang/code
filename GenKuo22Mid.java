import java.util.List;
import java.util.ArrayList;

class GenKuo22Mid{
    // 分步并且需要回溯的 使用回溯法
    // 二叉树root只有一个,所以root加入path,然后dfs(right) ,dfs(left),回溯
    // 当前有两种选择,每种选择dfs后都要移除,遍历进行dfs,每次dfs之后进行回溯
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generateParenthesis(n, n , sb, res);
        return res;
    }

    public static void generateParenthesis(int left, int right, StringBuilder prefix, List<String> res) {
        if(left == 0 && right == 0){
            if(isValid(prefix)){
                res.add(prefix.toString());
            }
        }
        if(left > 0){
            generateParenthesis(left - 1, right, prefix.append('('), res);
            prefix.deleteCharAt(prefix.length() - 1);
        }
        if(right > 0){
            prefix.append(')');
            if(isValid(prefix)){
                generateParenthesis(left, right - 1, prefix, res);
            }
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    public static boolean isValid(StringBuilder prefix){
        int count = 0;
        for(int i = 0; i < prefix.length(); i++){
            if(prefix.charAt(i) == '('){
                count++;
            }
            if(prefix.charAt(i) == ')'){
                count--;
            }
            if(count < 0 ){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
