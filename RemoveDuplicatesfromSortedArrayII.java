public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 1, j = 1;
        while (++j < nums.length) {
            if (nums[j] != nums[i] || nums[j] != nums[i - 1]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}