public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if (i == c.length) {
            if (num != 0) sb.append(num);
            res.add(sb.toString());
        } else {
            dfs(res, sb, c, i + 1, num + 1);
            
            if (num != 0) sb.append(num);
            dfs(res, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }
}