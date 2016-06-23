public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        StringBuilder prefix = new StringBuilder();
        
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        
        for (int j = 0; j < minLength; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) 
                    return prefix.toString();
            }
            prefix.append(strs[0].charAt(j));
        }
        
        return prefix.toString();
    }
}