public class Solution {
    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean hasNumber = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            hasNumber = true;
            i++;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                hasNumber = true;
                i++;
            }
        }
        if (hasNumber && i < n && s.charAt(i) == 'e') {
            i++;
            hasNumber = false;
             if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
             while (i < n && Character.isDigit(s.charAt(i))) {
                 i++;
                 hasNumber = true;
             }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        
        // Correct number appearance
        // And correct pattern
        return hasNumber && i == n;
    }
}