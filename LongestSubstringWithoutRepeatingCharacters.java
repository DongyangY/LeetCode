public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0, j = i;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}