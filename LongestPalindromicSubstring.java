public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        
        int l = 0, r = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int half = findPalindrome(s, i, i);
            if (half * 2 + 1 > r - l + 1) {
                l = i - half;
                r = i + half;
            }
            
            half = findPalindrome(s, i, i + 1);
            if (half * 2 + 2 > r - l + 1) {
                l = i - half;
                r = i + 1 + half;
            }
        }
        return s.substring(l, r + 1);
    }
    
    public int findPalindrome(String s, int i, int j) {
        int i_origin = i;
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return i_origin - (i + 1);
    }
}