public class Solution {
    private int total;
    
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] anti_diag = new boolean[2 * n - 1];
        solveNQueens(0, n, col, diag, anti_diag);
        return total;
    }
    
    private void solveNQueens(int row, int n, boolean[] col, boolean[] diag, boolean[] anti_diag) {
        if (row == n) {
            total++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag[j + row] && !anti_diag[j - row + n - 1]) {
                col[j] = true;
                diag[j + row] = true;
                anti_diag[j - row + n - 1] = true;
                solveNQueens(row + 1, n, col, diag, anti_diag);
                
                col[j] = false;
                diag[j + row] = false;
                anti_diag[j - row + n - 1] = false;
            }
        }
    }
}