public class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            c[i] ^= c[j];
            c[j] ^= c[i];
            c[i++] ^= c[j--];
        }
        return String.valueOf(c);
    }
}