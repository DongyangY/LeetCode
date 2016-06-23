public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return diffWaysToCompute(input, memo);
    }
    
    private List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> memo) {
        if (memo.get(input) != null) {
            return memo.get(input);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*') {
                continue;
            }
            
            String leftInput = input.substring(0, i);
            String rightInput = input.substring(i + 1, input.length());
            
            List<Integer> left = diffWaysToCompute(leftInput, memo);
            List<Integer> right = diffWaysToCompute(rightInput, memo);
            
            for (int l : left) {
                for (int r : right) {
                    if (c == '+') {
                        result.add(l + r);
                    } else if (c == '-') {
                        result.add(l - r);
                    } else if (c == '*') {
                        result.add(l * r);
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        
        memo.put(input, result);
        
        return result;
    }
}