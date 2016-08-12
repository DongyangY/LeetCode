public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.clear();
            int j;
            for (j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() > 2) {
                    break;
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}