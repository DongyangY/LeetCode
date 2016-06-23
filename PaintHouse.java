public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
            
        int m = costs.length + 1;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i - 1][2];
        }
        
        return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
    }
}