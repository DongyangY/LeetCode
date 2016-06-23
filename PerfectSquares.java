public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // Recurrence
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                // Get current by previous memories
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}