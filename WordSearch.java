public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int start, int i, int j) {
        if (start == word.length()) return true;
        
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] == '-') return false;
        if (board[i][j] != word.charAt(start)) return false;
        
        char temp = board[i][j];
        board[i][j] = '-';
        
        boolean result = dfs(board, word, start + 1, i - 1, j) || dfs(board, word, start + 1, i + 1, j) ||
            dfs(board, word, start + 1, i, j - 1) || dfs(board, word, start + 1, i, j + 1);
            
        board[i][j] = temp;
        return result;
    }
}