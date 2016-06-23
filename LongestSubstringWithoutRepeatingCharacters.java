public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // The position of char in the string
        int[] positions = new int[256];
        Arrays.fill(positions, -1);
        
        // Two-pass
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            // Appeared
            if (positions[s.charAt(j)] >= i) {
                i = positions[s.charAt(j)] + 1;
            }
            // Not appeared, then set position
            positions[s.charAt(j)] = j;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        
        return maxLen;
    }
}