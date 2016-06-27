public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        // the minimum stock price before day i inclusive
        int[] min = new int[prices.length];
        min[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min[i - 1], max);
            min[i] = Math.min(prices[i], min[i - 1]);
        }
        return max;
    }
}