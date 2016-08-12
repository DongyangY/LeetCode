public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(digits, 0, new StringBuilder(), res, map);
        return res;
    }
    
    private void letterCombinations(String s, int start, StringBuilder sb, List<String> res, String[] map) {
        if (start == s.length()) {
            res.add(sb.toString());
            return;
        }
        
        String choice = map[Integer.parseInt(String.valueOf(s.charAt(start)))];
        for (int i = 0; i < choice.length(); i++) {
            sb.append(choice.charAt(i));
            letterCombinations(s, start + 1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}