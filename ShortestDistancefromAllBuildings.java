public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        
        int min = Integer.MAX_VALUE;
        
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    num++;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(grid, i, j, num));
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int bfs(int[][] grid, int i, int j, int num) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] map = new int[m * n];
        for (int k = 0; k < map.length; k++) {
            map[k] = -1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        int sum = 0;
        int count = 0;
        
        map[i * n + j] = 0;
        queue.add(i * n + j);
        
        while (!queue.isEmpty()) {
            int top = queue.remove();
            int dis = map[top] + 1;
            
            int ti = top / n;
            int tj = top % n;
            
            int up = (ti - 1) * n + tj;
            if (ti - 1 >= 0 && map[up] == -1 && grid[ti - 1][tj] != 2) {
                map[up] = dis;
                if (grid[ti - 1][tj] == 0) {
                    queue.add(up);
                }
                if (grid[ti - 1][tj] == 1) {
                    sum += dis;
                    count++;
                }
            }
            
            int down = (ti + 1) * n + tj;
            if (ti + 1 < m && map[down] == -1 && grid[ti + 1][tj] != 2) {
                map[down] = dis;
                if (grid[ti + 1][tj] == 0) {
                    queue.add(down);
                }
                if (grid[ti + 1][tj] == 1) {
                    sum += dis;
                    count++;
                }
            }
            
            int left = ti * n + tj - 1;
            if (tj - 1 >= 0 && map[left] == -1 && grid[ti][tj - 1] != 2) {
                map[left] = dis;
                if (grid[ti][tj - 1] == 0) {
                    queue.add(left);
                }
                if (grid[ti][tj - 1] == 1) {
                    sum += dis;
                    count++;
                }
            }
            
            int right = ti * n + tj + 1;
            if (tj + 1 < n && map[right] == -1 && grid[ti][tj + 1] != 2) {
                map[right] = dis;
                if (grid[ti][tj + 1] == 0) {
                    queue.add(right);
                }
                if (grid[ti][tj + 1] == 1) {
                    sum += dis;
                    count++;
                }
            }
        }
        
        return count != num ? Integer.MAX_VALUE : sum;
    }
}