public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> sets = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, n, sb, sets);
        return sets;
    }
    
    public void generateParenthesis(int l, int r, 
        StringBuilder sb, List<String> sets) {
        if (l == 0 && r == 0) {
            sets.add(sb.toString());
            return;
        }
        
        if (l > r) return;
        
        if (l != 0) {
            sb.append("(");
            generateParenthesis(l - 1, r, sb, sets);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (r != 0) {
            sb.append(")");
            generateParenthesis(l, r - 1, sb, sets);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return;
    }
}