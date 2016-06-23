public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int sideLen = 0;
        
        // base cases
        for (int i = 0; i < n; i++) {
            memo[0][i] = Character.getNumericValue(matrix[0][i]);
            if (memo[0][i] == 1) sideLen = 1;
        }
        
        for (int i = 0; i < m; i++) {
            memo[i][0] = Character.getNumericValue(matrix[i][0]);
            if (memo[i][0] == 1) sideLen = 1;
        }
        
        // recurrence
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int min = Math.min(memo[i - 1][j], memo[i][j - 1]);
                    min = Math.min(min, memo[i - 1][j - 1]);
                    memo[i][j] = min + 1;
                    sideLen = Math.max(sideLen, memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        
        return sideLen * sideLen;
    }
}