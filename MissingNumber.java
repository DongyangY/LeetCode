public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = (n - 1) * n / 2;
        for (int i : nums) sum -= i;
        return sum;
    }
}