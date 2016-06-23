public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(nonCycleRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
            nonCycleRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    
    public int nonCycleRob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }
}