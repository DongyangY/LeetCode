public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 2)
            return nums;
        
        int x1xorx2 = 0;
        for (int i : nums) {
            x1xorx2 ^= i;
        }
        
        int lastBit = x1xorx2 - (x1xorx2 & (x1xorx2 - 1));
        int[] result = new int[2];
        for (int i : nums) {
            if ((lastBit & i) == 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        
        return result;
    }
}