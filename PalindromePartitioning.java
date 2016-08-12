public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> t = new ArrayList<>();
        partition(s, 0, t, res);
        return res;
    }
    
    private boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private void partition(String s, int start, List<String> t, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(t));
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalin(sub)) {
                t.add(sub);
                partition(s, i, t, res);
                t.remove(t.size() - 1);
            }
        }
    }
}