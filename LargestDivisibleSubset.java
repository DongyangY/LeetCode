public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        int[] next = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            next[i] = i;
        }
        
        int max = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    next[i] = j;
                }
            }
            
            if (dp[i] > dp[max]) max = i;
        }
        
        list.add(nums[max]);
        while (max != next[max]) {
            max = next[max];
            list.add(nums[max]);
        }
        
        return list;
    }
}