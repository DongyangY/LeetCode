public class Solution {
    public int numWays(int n, int k) {
        int[] dp = { 0, k, k * k};
        if (n < 3) return dp[n];
        for (int i = 3; i <= n; i++) {
            int t = (k - 1) * (dp[2] + dp[1]);
            dp[1] = dp[2];
            dp[2] = t;
        }
        return dp[2];
    }
}