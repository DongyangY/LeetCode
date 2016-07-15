public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int rowCache = 0;
        int[] colCache = new int[n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 < 0 || grid[i][j - 1] == 'W') {
                    rowCache = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCache++;
                    }
                }
                if (i - 1 < 0 || grid[i - 1][j] == 'W') {
                    colCache[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCache[j]++;
                    }
                }
                if (grid[i][j] == '0') {
                    ret = Math.max(ret, rowCache + colCache[j]);
                }
            }
        }
        return ret;
    }
}