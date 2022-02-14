class NumIslands200Mid{
    public static int numIslands(char[][] grid) {
        // 遇到一个新的岛，结果++，然后走完这座岛，全部标记为已达
        // 遇到一个已达的岛或者是水，跳过
        // 由于不止存在z字型的岛，还有3字型等，遇到左上的路不会走会漏掉
        // 所以需要往4个方向走
        if(grid == null ||grid.length == 0 ||grid[0].length == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j <grid[i].length; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j);
                }

            }
        }
        return ans;
    }
    public static void dfs(char[][] grid, int i, int j){
        if(i < 0 ||j < 0 ||i >= grid.length ||j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
    public static void main(String[] args) {
        // 1
        System.out.println(numIslands(new char[][]{
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        }));
    }
}
