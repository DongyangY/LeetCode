public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return null;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}