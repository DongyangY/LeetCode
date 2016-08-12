public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0) return 0;
        int max = 0;
        Map<Character, Set<Integer>> map = new HashMap<>();
        int i = 0, j = -1;
        while (j < s.length()) {
            if (map.size() > k) {
                char h = s.charAt(i);
                Set<Integer> set = map.get(h);
                set.remove(i);
                if (set.size() == 0) {
                    map.remove(h);
                }
                i++;
                continue;
            }
            
            j++;
            
            if (j >= s.length()) {
                max = Math.max(max, j - i);
                break;
            }
            
            char t = s.charAt(j);
            if (map.containsKey(t)) {
                map.get(t).add(j);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(j);
                map.put(t, set);
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}