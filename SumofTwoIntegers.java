public class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = a & b;
        
        while (and != 0) {
            and <<= 1;
            int t = xor;
            xor ^= and;
            and &= t;
        }
        
        return xor;
    }
}