public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[(int)s.charAt(i) - 'a']++;
            alph[(int)t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) return false;
        }
        return true;
    }
}