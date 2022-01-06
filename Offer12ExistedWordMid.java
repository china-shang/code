import java.util.Set;
import java.util.HashSet;

class Offer12ExistedWordMid{
    private static char[][] board;

    // 使用\0标记已走过的位置
    public static boolean exist(char[][] b, String word) {
        if(b == null || b.length == 0 ){
            return false;
        }
        board = b;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(i, j, word)){
                    return true;
                }
            }
        }


        return false;
    }
    public static boolean exist(int i, int j, String word){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(0)){
            return false;
        }
        if(word.length() == 1){
            return true;
        }

        String remain = word.substring(1, word.length());
        board[i][j] = '\0';

        boolean success =  exist(i+1, j, remain) || exist(i-1, j, remain) || exist(i, j+1, remain) || exist(i, j-1,remain);
        if(success){
            return success;
        } else {
            board[i][j] = word.charAt(0);
            return false;
        }


    }

    public static void main(String[] args) {
        char[][] board = new char[5][5];
        board[0] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[1] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[2] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[3] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[4] = new char[]{'a', 'b', 'c', 'd', 'e'};

        // false
        System.out.println(exist(board, "abbbbbaaaab"));

        // false
        System.out.println(exist(board, "abbbbbaaaac"));

        // true
        System.out.println(exist(board, "abcdeedddcba"));
    }
}
