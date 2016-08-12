public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
            
        int n = prices.length;
        int[] hold = new int[n];
        int[] nothold = new int[n];
        
        hold[0] = -prices[0];
        hold[1] = Math.max(hold[0], -prices[1]);
        nothold[0] = 0;
        nothold[1] = Math.max(nothold[0], hold[0] + prices[1]);
        
        for (int i = 2; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], nothold[i - 2] - prices[i]);
            nothold[i] = Math.max(nothold[i - 1], hold[i - 1] + prices[i]);
        }
        
        return nothold[n - 1];
    }
}