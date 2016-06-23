public class Solution {
    public int maxProfit(int[] prices) {
        // record the minimum price so far
        int min = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(prices[i] - min, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}