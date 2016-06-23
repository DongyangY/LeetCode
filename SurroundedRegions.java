public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) 
            return;
            
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                solve(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                solve(board, i, n - 1);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                solve(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                solve(board, m - 1, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void solve(char[][] board, int i, int j) {
        int n = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        fill(board, i, j, queue);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n;
            int y = cur % n;
            fill(board, x - 1, y, queue);
            fill(board, x + 1, y, queue);
            fill(board, x, y - 1, queue);
            fill(board, x, y + 1, queue);
        }
    }
    
    private void fill(char[][] board, int i, int j, Queue<Integer> queue) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        queue.offer(i * n + j);
        board[i][j] = '#';
    }
}