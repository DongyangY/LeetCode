public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        
        for (int k = 0; k < nums.length; k++) {
            // the smallest
            if (nums[k] <= i) {
                i = nums[k];
                continue;
            }
            // the second smallest and guarantee pos i < pos j
            if (nums[k] <= j) {
                j = nums[k];
                continue;
            }
            // come here means i and j are founded, and the current is larger than them
            return true;
        }
        return false;
    }
}