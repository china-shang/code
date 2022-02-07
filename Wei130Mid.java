class Wei130Mid {
    private static int m;
    private static int n;
    // 所有保留的O都和边界的O相连,从边界dfs所有的O置为A
    // 然后遍历把O改为X,把A改为O
    public static void solve(char[][] board){
        if(board == null || board.length == 0){
            return ;
        }
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for(int i = 0; i < n; i++){
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][]board, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
    public static void main(String[] args) {

    }
}
