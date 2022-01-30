import java.util.List;

class TriangleMinPath120Mid{
    // 从开始往结尾推,dfs求出两个节点的长度,每一步都走最短的路径
    // 使用动态规划正向递推,滚动数组优化空间
    public static int minimumTotal(List<List<Integer>> triangle){
        int[]dp = new int[triangle.size()];
        for(int i = 0; i < triangle.size(); i++){
            for(int j = 0; j < triangle.size() - i; j++){
                if(i == 0){
                    dp[j] = triangle.get(triangle.size() - i -1).get(j);
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(triangle.size() -i -1).get(j);
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
