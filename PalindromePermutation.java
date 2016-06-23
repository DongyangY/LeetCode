public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] chars = new boolean[128]; 
        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i);
            chars[index] = !chars[index];
        }
        
        int single = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]) single++;
        }
        
        return single > 1 ? false : true;
    }
}