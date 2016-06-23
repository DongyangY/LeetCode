public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        
        String str = removeNonAlpha(s);
        int li = 0, ri = str.length() - 1;
        while (li < ri) {
            char lc = str.charAt(li++);
            char rc = str.charAt(ri--);
            if (isNumber(lc) || isNumber(rc)) {
                if (lc != rc) return false;
            } else {
                int distance = 'a' - 'A';
                if ((lc < rc && lc + distance != rc) ||
                    (rc < lc && rc + distance != lc)) return false;
            }
        }
        return true;
    }
    
    public String removeNonAlpha(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLowerCase(c) || isUpperCase(c) || isNumber(c)) sb.append(c);
        }
        return sb.toString();
    }
    
    public boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
    
    public boolean isLowerCase(char c) {
        return (c >= 'a' && c <= 'z');
    }
    
    public boolean isUpperCase(char c) {
        return (c >= 'A' && c <= 'Z');
    }
}