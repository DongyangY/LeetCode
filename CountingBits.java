public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int pow1 = 1, pow2 = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow2) {
                pow1 = pow2;
                pow2 <<= 1;
                res[pow1] = 1;
            } else {
                res[i] = 1 + res[i - pow1];
            }
        }
        return res;
    }
}