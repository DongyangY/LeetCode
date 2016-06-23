public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, m, n, i, j, 0)) 
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word, int m, int n, int i, int j, int cur) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(cur)) 
            return false;
        if (cur == word.length() - 1)  return true;
        else {
            char temp = board[i][j];
            board[i][j] = '#';
            // Note must pass + 1 - not ++ which will change the value in this stage
            boolean res = exist(board, word, m, n, i + 1, j, cur + 1) || 
                   exist(board, word, m, n, i - 1, j, cur + 1) ||
                   exist(board, word, m, n, i, j + 1, cur + 1) ||
                   exist(board, word, m, n, i, j - 1, cur + 1);
            board[i][j] = temp;
            return res;
        }
    }
}