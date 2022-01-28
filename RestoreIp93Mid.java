import java.util.List;
import java.util.ArrayList;
class RestoreIp93Mid{
    private static List<String> res;
    // 分步使用回溯,每一步,可选拿1-3个,从当前字符开始拿,符合大小才进行下一步
    // 需要记录path,需要记录当前拿到哪个字符了
    // path.size() == 4 || start=length,同时满足说明是一个解,否则失败
    // 0开头不能和之后的数字组合,只能作为0,当前步直接使用0
    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s==null || s.length() < 4){
            return res;
        }
        restoreIpAddresses(s, 0, new ArrayList<>());
        return res;
    }
    public static void restoreIpAddresses(String s, int start, List<Integer> path){
        if(path.size() == 4 || start >= s.length()){
            if(start == s.length() && path.size() == 4){
                res.add(path.get(0)+"."+path.get(1)+"."+path.get(2)+"."+path.get(3));
            }
            return;
        }
        if(s.charAt(start) == '0'){
                path.add(0);
                restoreIpAddresses(s, start + 1, path);
                path.remove(path.size() - 1);
                return ;
        }
        int n = 0;
        for(int i = start; i < s.length() && i <= start + 2; i++){
            n = n * 10 + s.charAt(i) - '0';
            if(n >=0 && n <= 255){
                path.add(n);
                restoreIpAddresses(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("11111"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
