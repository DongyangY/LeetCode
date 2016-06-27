public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int n = s.length();
        Character char1, char2;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char1 = null; 
            char2 = null;
            int j;
            for (j = i; j < n; j++) {
                char c = s.charAt(j);
                if (char1 == null) {
                    char1 = c;
                } else {
                    if (c == char1) {
                        continue;       
                    } else {
                        if (char2 == null) {
                             char2 = c;
                        } else {
                            if (c == char2) {
                                continue;
                            } else {
                                max = Math.max(max, j - i);
                                break;
                            }
                        }
                    }
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}