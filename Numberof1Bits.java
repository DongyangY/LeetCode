public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 0x00000001) == 1) sum++;
            n >>= 1;
        }
        return sum;
    }
}