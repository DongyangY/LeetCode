public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int temp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], temp * nums[i]);
            }
            
            result = Math.max(result, max);
        }
        return result;
    }
}