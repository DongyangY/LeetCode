public class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return isScramble(s1, s2, map);
    }
    
    public boolean isScramble(String s1, String s2, Map<String, Boolean> map) {
        String key = s1 + " " + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        
        int m = s1.length();
        if (m == 1) {
            map.put(key, false);
            return false;
        }
        
        for (int i = 1; i < m; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, m);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, m);
            String s23 = s2.substring(m - i, m);
            String s24 = s2.substring(0, m - i);
            if (isScramble(s11, s21, map) && isScramble(s12, s22, map)) {
                map.put(key, true);
                return true;
            }
            if (isScramble(s11, s23, map) && isScramble(s12, s24, map)) {
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}