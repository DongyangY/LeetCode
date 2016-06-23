public class Solution {
    public int titleToNumber(String s) {
        int sum = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = (int)s.charAt(i) - 64;
            sum += num * base;
            base *= 26;
        }
        return sum;
    }
}