/**
 * {1, 2} 3
 * 
 * c[0] = 1
 * c[1] += c[1 - 1]
 * c[2] += c[2 - 1]
 * c[2] += c[2 - 2]
 * c[3] += c[3 - 1]
 * c[3] += c[3 - 2]
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    count[i] += count[i - n];
                }
            }
        }
        return count[target];
    }
}