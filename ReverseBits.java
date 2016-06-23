public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int lb = n >> i & 1;
            int mb = n >> (32 - i - 1) & 1;
            if ((lb ^ mb) != 0) {
                // 1 ^ bit == ~bit
                n ^= 1 << i | 1 << (32 - i - 1);
            }
        }
        return n;
    }
}