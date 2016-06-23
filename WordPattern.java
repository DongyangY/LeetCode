public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)) {
                if (map.containsValue(words[i])) return false;
                else map.put(c, words[i]);
            } else if (!map.get(c).equals(words[i])) return false;
        }
        return true;
    }
}