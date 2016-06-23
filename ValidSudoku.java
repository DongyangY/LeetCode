public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j]) && !set.add(board[i][j])) return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[j][i]) && !set.add(board[j][i])) return false;
            }
        }
        
        for (int block = 0; block < 9; block++) {
            set.clear();
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (Character.isDigit(board[i][j]) && !set.add(board[i][j])) return false;
                }
            }    
        }
        
        return true;
    }
}