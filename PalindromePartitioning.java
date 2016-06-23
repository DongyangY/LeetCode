public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sets = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        partition(s, 0, tmp, sets);
        return sets;
    }
    
    public void partition(String s, int start, List<String> tmp, 
        List<List<String>> sets) {
        if (start >= s.length()) {
            /*
            for (String str : tmp) {
                System.out.print(str);
                System.out.print(",");
            }
            System.out.println();
            */
            sets.add(new ArrayList<String>(tmp));
            return;
        }
        
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalindrome(sub)) {
                tmp.add(sub);
                partition(s, i, tmp, sets);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}