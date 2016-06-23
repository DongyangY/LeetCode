public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (needle.length() == 0) return 0;
        return search(haystack, construct(needle));
    }
    
    public int search(String txt, int[][] dfa) {
        for (int i = 0, j = 0; i < txt.length(); i++) {
            j = dfa[txt.charAt(i)][j];
            if (j == dfa[0].length) {
                return i - dfa[0].length + 1;
            }
        }
        return -1;
    }
    
    public int[][] construct(String pat) {
        int[][] dfa = new int[256][pat.length()];
        dfa[pat.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < pat.length(); j++) {
            for (int c = 0; c < 256; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            x = dfa[pat.charAt(j)][x];
        }
        return dfa;
    }
}