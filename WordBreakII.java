public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        boolean[] memo = new boolean[s.length() + 1];
        wordBreak(s, 0, wordDict, temp, result, memo);
        return result;
    }
    
    public void wordBreak(String s, int start, Set<String> wordDict, List<String> temp, List<String> result, boolean[] memo) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i != temp.size() - 1) 
                    sb.append(" ");
            }
            result.add(sb.toString());
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String t = s.substring(start, i);
            // next iteration uses the memo before recursion
            // avoid repeat recursion
            if (wordDict.contains(t) && !memo[i]) {
                temp.add(t);
                int oldSize = result.size();
                wordBreak(s, i, wordDict, temp, result, memo);
                // recursion return position
                // bottom-up start
                // get base's info to build bigger problem
                // use result's size to check if solution start from i
                if (result.size() == oldSize) {
                    memo[i] = true;
                }
                temp.remove(temp.size() - 1);
            }
        }
    }
}