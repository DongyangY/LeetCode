public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int min = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            int right = searchRight(i + 1, nums.length, sums[i] + s, sums);
            if (right > nums.length) break;
            min = (min == 0) ? right - i : Math.min(min, right - i);
        }
        
        return min;
    }
    
    public int searchRight(int left, int right, int target, int[] sums) {
        // left is always the minimum which is larger than target
        // use mid - 1 & mid + 1 pattern
        // left > length - 1 means target is larger than all numbers
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}