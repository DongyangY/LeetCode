public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int min = Integer.MAX_VALUE;
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int len = bfs(grid, i, j, count);
                    min = Math.min(min, len);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    class Step {
        int pos;
        int dis;
        public Step(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }
    
    private int bfs(int[][] grid, int si, int sj, int count) {
        int len = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        Queue<Step> queue = new LinkedList<>();
        int pos = si * n + sj;
        queue.add(new Step(pos, 0));
        visited[pos] = true;
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            Step top = queue.remove();
            
            int i = top.pos / n;
            int j = top.pos % n;
            
            if (grid[i][j] == 1) {
                len += top.dis;
                cnt++;
                continue;
            }
            
            pos = (i - 1) * n + j;
            if (i - 1 >= 0 && grid[i - 1][j] != 2 && !visited[pos]) {
                visited[pos] = true;
                queue.add(new Step(pos, top.dis + 1));
            }
            
            pos = (i + 1) * n + j;
            if (i + 1 < m && grid[i + 1][j] != 2 && !visited[pos]) {
                visited[pos] = true;
                queue.add(new Step(pos, top.dis + 1));
            }
            
            pos = i * n + j - 1;
            if (j - 1 >= 0 && grid[i][j - 1] != 2 && !visited[pos]) {
                visited[pos] = true;
                queue.add(new Step(pos, top.dis + 1));
            }
            
            pos = i * n + j + 1;
            if (j + 1 < n && grid[i][j + 1] != 2 && !visited[pos]) {
                visited[pos] = true;
                queue.add(new Step(pos, top.dis + 1));
            }
        }
        
        if (cnt == count) {
            return len;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}