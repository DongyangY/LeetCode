public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[2][prices.length + 1];
        
        for (int i = prices.length - 1; i >= 0; i--) {
            dp[0][i] = Math.max(dp[0][i + 1], dp[1][i + 1] - prices[i]);
            dp[1][i] = Math.max(dp[1][i + 1], dp[0][i + 1] + prices[i]);
        }
        
        return dp[0][0]; 
    }
}