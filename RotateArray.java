public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        if (k % n == 0) return;
        k = k % n;
        reverse(n - k, n - 1, nums);
        reverse(0, n - k - 1, nums);
        reverse(0, n - 1, nums);
    }
    
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}