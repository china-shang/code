import java.util.List;
import java.util.ArrayList;

class SelCourse207Mid{
    private static boolean can;
    // 问题即为判断图是否有环
    // 给出了图的拓扑排序,无法快速定位一个节点能抵达的下一节点
    // 使用List<List>存储每个节点能够抵达的节点
    // 然后从没有遇到的所有节点开始dfs遍历，如果遇到遍历中的节点说明回来了，有环
    // 如果遇到已遍历的节点忽略，遇到未遍历的节点，dfs遍历.
    // 在循环中使用can作为是否继续循环的依据，进行优化
    // 遍历完都无环即可行;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        can = true;
        for(int i = 0; i < numCourses && can; i++){
            if(visited[i] == 0){
                dfs(visited, list, i);
            }
        }
        return can;
    }

    public static void dfs(int[] visited, List<List<Integer>> list, int i){
        visited[i] = 1;
        for(int j = 0; j < list.get(i).size() && can; j++){
            int pos = list.get(i).get(j);
            if(visited[pos] == 0){
                dfs(visited, list, pos);
            } else if(visited[pos] == 1){
                can = false;
                return ;
            }
        }
        visited[i] = 2;
    }
    public static void main(String[] args) {
        // numCourses = 2, prerequisites = [[1,0],[0,1]];
        // false
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));

        // true
        System.out.println(canFinish(20, new int[][]{{1, 0}, {3, 1}}));
    }
}
