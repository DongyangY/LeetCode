/*
    0: 0 -> 0
    1: 1 -> 1
    2: 1 -> 0
    3: 0 -> 1
*/
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = update(board, i, j, m, n);        
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
    
    public int update(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k == i && l == j) continue;
                if (k < 0 || k >= m || l < 0 || l >= n) continue;
                if (board[k][l] == 1 || board[k][l] == 2) lives++;
            }
        }
        
        if (board[i][j] == 1) {
            return (lives == 2 || lives == 3) ? 1 : 2;
        } else {
            return lives == 3 ? 3 : 0;
        }
    }
}