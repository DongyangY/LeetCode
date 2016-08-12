public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return wordBreak(s, wordDict, 0, map);
    }
    
    private boolean wordBreak(String s, Set<String> set, int start, Map<String, Boolean> map) {
        if (start == s.length()) return true;
        String str = s.substring(start, s.length());
        if (map.containsKey(str)) return map.get(str);
        
        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {
                String sub = s.substring(i, s.length());
                if (wordBreak(s, set, i, map)) {
                    map.put(sub, true);
                    return true;
                } else {
                    map.put(sub, false);
                }
            }
        }
        
        map.put(str, false);
        return false;
    }
}