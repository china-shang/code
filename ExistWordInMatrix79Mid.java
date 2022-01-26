class ExistWordInMatrix79Mid{
    private static boolean[][] has;
    // dfs中处理本节点,判断本节点是否符合,然后直接试图走到下一个节点,在节点中记录,dfs,回溯
    // dfs中判断下一个节点是否符合,如果符合,走到下一个节点,每个dfs中都是在处理下一个节点,在此记录,dfs,回溯下一个节点
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0 || word == null){
            return false;
        }
        has = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(exist(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean exist(char[][] board, String word, int i, int j, int pos){
        if(pos == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(pos) || has[i][j]){
            return false;
        }
        has[i][j] = true;
        if(exist(board, word, i, j+1, pos+1)){
            return true;
        }
        if(exist(board, word, i, j-1, pos+1)){
            return true;
        }
        if(exist(board, word, i+1, j, pos+1)){
            return true;
        }
        if(exist(board, word, i-1, j, pos+1)){
            return true;
        }
        has[i][j] = false;
        return false;
    }
    public static void main(String[] args) {

    }
}
