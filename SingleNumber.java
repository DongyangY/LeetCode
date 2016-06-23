public class Solution {
    
    // A XOR A == 0
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int n : nums) {
            single ^= n;
        }
        return single;
    }
}