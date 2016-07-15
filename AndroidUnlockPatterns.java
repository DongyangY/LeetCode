public class Solution {
    public int numberOfPatterns(int m, int n) {
        if (!(m >= 1 && n >= m && n <= 9)) return 0;
        boolean[] visited = new boolean[9];
        
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = numberOfPatterns(m, n, 1, visited, i, j);
                //System.out.println((i * 3 + j) + "," + num);
                count += num;
            }
        }
        return count;
        
        /*
        return numberOfPatterns(m, n, 1, visited, 0, 0) * 4 + 
               numberOfPatterns(m, n, 1, visited, 0, 1) * 4 + 
               numberOfPatterns(m, n, 1, visited, 1, 1);
        */
               
    }
    
    private int numberOfPatterns(int m, int n, int len, boolean[] visited, int x, int y) {
        int count = 0;
        if (len > n) return count;
        visited[x * 3 + y] = true;
        if (len >= m) {
            count++;
            //System.out.println(x * 3 + y);
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (((x + i) % 2 != 0 || (y + j) % 2 != 0 || visited[(x + i) / 2 * 3 + (y + j) / 2]) && 
                    !visited[i * 3 + j]) {
                    count += numberOfPatterns(m, n, len + 1, visited, i, j);
                }
            }
        }
        
        visited[x * 3 + y] = false;
        return count;
    }
}