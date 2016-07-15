public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] anti_diag = new boolean[2 * n - 1];
        solveNQueens(0, n, board, result, col, diag, anti_diag);
        return result;
    }
    
    private void solveNQueens(int row, int n, char[][] board, List<List<String>> result, 
        boolean[] col, boolean[] diag, boolean[] anti_diag) {
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(new String(board[i]));
            }
            result.add(l);
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag[j + row] && !anti_diag[j - row + n - 1]) {
                col[j] = true;
                diag[j + row] = true;
                anti_diag[j - row + n - 1] = true;
                board[row][j] = 'Q';
                solveNQueens(row + 1, n, board, result, col, diag, anti_diag);
                
                col[j] = false;
                diag[j + row] = false;
                anti_diag[j - row + n - 1] = false;
                board[row][j] = '.';
            }
        }
    }
}