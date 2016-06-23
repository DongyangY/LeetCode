public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> replace = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (replace.containsKey(sc)) {
                if (replace.get(sc) != tc) return false;
            } else {
                if (replace.containsValue(tc)) return false;
                else replace.put(sc, tc);
            }
        }
        return true;
    }
}