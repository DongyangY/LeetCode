public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int[] memo = new int[n + 1];
        memo[2] = 2;
        memo[3] = 3;
        for (int i = 4; i <= n; i++) {
            memo[i] = Math.max(memo[i - 2] * 2, memo[i - 3] * 3);
        }
        return memo[n];
    }
}