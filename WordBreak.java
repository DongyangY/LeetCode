public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (memo[j] && wordDict.contains(sub)) {
                    memo[i] = true;
                }
            }
        }
        return memo[s.length()];
    }
}