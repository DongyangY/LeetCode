public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0)
            return false;
        return canWin(s.toCharArray());
    }
    
    public boolean canWin(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                
                boolean win = canWin(arr);
                
                arr[i] = '+';
                arr[i + 1] = '+';
                
                if (!win) {
                    return true;
                }
            }
        }
        return false;
    }
}