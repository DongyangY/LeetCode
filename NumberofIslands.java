public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || 
            grid[0].length == 0)
            return 0;
            
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0' && grid[i][j] != '2') {
                    count++;
                    numIslands(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void numIslands(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        
        grid[i][j] = '2';
        
        numIslands(grid, i - 1, j);
        numIslands(grid, i + 1, j);
        numIslands(grid, i, j - 1);
        numIslands(grid, i, j + 1);
    }
}