public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = 0;
                if (i - 1 < 0 && j - 1 >= 0) min = mem[i][j - 1];
                if (i - 1 >= 0 && j - 1 < 0) min = mem[i - 1][j];
                if (i - 1 >= 0 && j - 1 >= 0)
                    min = Math.min(mem[i - 1][j], mem[i][j - 1]);
                mem[i][j] = min + grid[i][j];
            }
        }
        return mem[m - 1][n - 1];
    }
}