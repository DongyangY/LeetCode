public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] == '0' ? 0 : 1; 
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : dp[i][j + 1] + 1;
            }
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = dp[i][j];
                for (int k = i; k < m; k++) {
                    width = Math.min(width, dp[k][j]);
                    max = Math.max(max, width * (k - i + 1));
                }
            }
        }
        
        return max;
    }
}