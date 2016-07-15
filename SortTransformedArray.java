public class Solution {
    
    public int form(int x, int a, int b, int c) {
        return a * x * x + b * x + c;    
    }
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                int k = b > 0 ? i : nums.length - 1 - i;
                result[k] = form(nums[i], a, b, c);
            }
        } else if (a > 0) {
            int i = 0, j = nums.length - 1;
            for (int k = nums.length - 1; k >= 0; k--) {
                int left = form(nums[i], a, b, c);
                int right = form(nums[j], a, b, c);
                if (left > right) {
                    result[k] = left;
                    i++;
                } else {
                    result[k] = right;
                    j--;
                }
            }
        } else {
            int i = 0, j = nums.length - 1;
            for (int k = 0; k < nums.length; k++) {
                int left = form(nums[i], a, b, c);
                int right = form(nums[j], a, b, c);
                if (left < right) {
                    result[k] = left;
                    i++;
                } else {
                    result[k] = right;
                    j--;
                }
            }
        }
        
        return result;
    }
}