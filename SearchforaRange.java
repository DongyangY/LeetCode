public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        findBound(range, 0, nums, target);
        findBound(range, 1, nums, target);
        return range;
    }
    
    public void findBound(int[] range, int index, int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (index == 0) {
                    range[0] = mid;
                    right = mid - 1;
                } else {
                    range[1] = mid;
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
    }
}