public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] mul = new int[nums.length];
        mul[mul.length - 1] = 1;
        for (int i = mul.length - 2; i >= 0; i--) {
            mul[i] = mul[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < mul.length; i++) {
            mul[i] *= left;
            left *= nums[i];
        }
        return mul;
    }
}