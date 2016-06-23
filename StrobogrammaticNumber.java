/*
    case: palindrome & 0, 1, 8 only
    case: 6, 9 must be opposite from each other
    
    xxxx
    
    xxx
*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!isStrobogrammatic(num.charAt(left++), num.charAt(right--))) return false;
        }
        return true;
    }
    
    public boolean isStrobogrammatic(char l, char r) {
        if (l == r && (l == '0' || l == '1' || l == '8'))
            return true;
        if ((l == '6' && r == '9') || (l == '9' && r == '6'))
            return true;
        return false;
    }
}