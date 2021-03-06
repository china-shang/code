class ValidSudo36Mid {
    public static boolean isValidSudoku(char[][] board) {
        int [][] rows = new int[9][9];
        int [][] cols = new int[9][9];
        int [][][] sub = new int[3][3][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int index = board[i][j] - '0' - 1;
                rows[i][index]++;
                cols[j][index]++;
                sub[i / 3][j / 3][index]++;
                if(rows[i][index] > 1 || cols[j][index] > 1 || sub[i/3][j/3][index] > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
