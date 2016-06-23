public class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // What if the last digit cause the overflow?
            if (Math.abs(rev) > Integer.MAX_VALUE / 10) return 0;
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}