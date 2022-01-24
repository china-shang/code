import java.util.Deque;
import java.util.LinkedList;

class SimplifyPath71Mid {

    //path按/拆分后就是路径,如果是.或空 代表当前, .. 代表之前,其他的代表特定目录
    //如果是普通路径直接添加,如果是当前需要无视,如果是..需要弹出最后一个目录
    //使用stack,如果是..弹出,如果是非当前目录为压入
    //最后遍历stack,构造path
    //如果同时使用stack与list,使用pollFirst pollLast,不要使用push,因为不知道push的实现
    public static String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] paths = path.split("/");
        for(String p: paths){
            if("..".equals(p)){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            } else if(!".".equals(p) && !p.isEmpty()){
                deque.offerLast(p);
            }
        }
        if(deque.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            String p = deque.pollFirst();
            sb.append("/").append(p);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("//../../test/./.idea/"));
    }
}
