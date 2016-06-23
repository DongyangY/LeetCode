public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // base case
        dp[0] = 0;
        
        // from base to built further
        for (int i = 0; i <= amount; i++) {
            for (int c : coins) {
                if (i + c <= amount && 
                    dp[i] != Integer.MAX_VALUE) {
                    dp[i + c] = Math.min(dp[i + c], dp[i] + 1);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}