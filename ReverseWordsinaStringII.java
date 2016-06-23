public class Solution {
    public void reverseWords(char[] s) {
        
        // Reverse the all chars
        reverseChars(s, 0, s.length - 1);
        
        // Reverse each word
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            
            // Order of the OR conditions is important
            // Condition 1 is accepted
            // Then condition 2 will not be tested
            if (j == s.length - 1 || s[j + 1] == ' ') {
                reverseChars(s, i, j);
                i = j + 2;
            }
        }
    }
    
    public void reverseChars(char[] s, int start, int end) {
        int l = start, r = end;
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}