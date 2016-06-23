public class Solution {
    public void moveZeroes(int[] nums) {
        /*
        int zero = 0, nonzero = 0;
        while (zero < nums.length && nonzero < nums.length) {
            if (nums[zero] != 0) zero++;
            else if (nums[nonzero] == 0 || nonzero <= zero) nonzero++;
            else swap(nums, zero++, nonzero++);
        }
        */
        
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) swap(nums, slow++, fast);
            fast++;
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}