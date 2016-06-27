public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n < 2) {
            return 0;
        }
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        right[n - 1] = 0;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}