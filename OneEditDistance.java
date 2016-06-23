public class Solution {
    
    // Break down the cases
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length(), tl = t.length();
        // Eliminate the sl > tl case solution
        if (sl > tl) return isOneEditDistance(t, s);
        if (tl - sl > 1) return false;
        int i = 0, shift = tl - sl;
        // One pass
        while (i < sl && s.charAt(i) == t.charAt(i)) i++;
        // 1 ~ sl all the same, shift should be 1
        if (i == sl) return shift == 1;
        if (shift == 0) i++;
        while (i < sl && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == sl;
    }
}