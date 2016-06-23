

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // Loop here indicating a carry
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        // Here indicating all 9
        int[] d = new int[digits.length + 1];
        System.arraycopy(digits, 0, d, 1, digits.length);
        d[0] = 1;
        return d;
    }
}