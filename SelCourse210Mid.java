import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class SelCourse210Mid{
    private static boolean valid;
    private static int[] stack;
    private static int idx;
    // 图的拓扑排序,首先转换为List<List>形式的图，方便找到node相连的node
    // 然后dfs遍历，如果出现环，即dfs发现node处于遍历中状态，说明回来了，return new int[]{},否则采用后序遍历
    // 如果使用前->后，那么后序遍历会先遍历完node之后的节点,此时stack[idx--]=i往前加
    // 如果使用后->前，那么node之前的节点会先遍历完,arr[idx++]=i,继续往后加
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int[] order: prerequisites){
            list.get(order[1]).add(order[0]);
        }
        stack = new int[numCourses];
        idx = numCourses - 1;
        int[] visited = new int[numCourses];
        valid = true;
        for(int i = 0; i < numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(list, visited, i);
            }
        }
        if(!valid){
            return new int[]{};
        }
        return stack;
    }
    public static void dfs(List<List<Integer>> list, int[] visited, int i){
        visited[i] = 1;
        for(int j : list.get(i)){
            if(visited[j] == 0){
                dfs(list, visited, j);
            } else if (visited[j] == 1){
                valid = false;
            }
            if(!valid){
                return ;
            }
        }
        visited[i] = 2;
        stack[idx--] = i;
    }
    public static void main(String[] args) {
        //  [0,2,1,3]
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
