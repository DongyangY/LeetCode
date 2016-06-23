/*
    DFS or BFS
    each digit as a node
    each letter of a node as a child
*/

public class Solution {
    private final String[] DIGIT_TO_STRING = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        ArrayList<Character> dp = new ArrayList<Character>();
        
        if (digits == null || digits.length() == 0) return result;
        letterCombinations(digits, result, dp);
        
        return result;
    }
    
    public void letterCombinations(String digits, List<String> result, ArrayList<Character> dp) {
        
        // bottom
        if (digits.length() == 0) {
            char[] chars = new char[dp.size()];
            for (int i = 0; i < dp.size(); i++) {
                chars[i] = dp.get(i);
            }
            result.add(String.valueOf(chars));
            return;
        }

        int number = Integer.parseInt(digits.substring(0, 1));
        String str = DIGIT_TO_STRING[number];
        
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            dp.add(chr);
            letterCombinations(digits.substring(1), result, dp);
            dp.remove(dp.size() - 1);
        }
    }
}