/*
    4
        A   G   M
        B F H L N
        C E I K
        D   J
    
    chars:    0 1 2 3 4 5 6 7 8 9 10 ..
    builders: 0 1 2 3 2 1 0 1 2 3 2 ...
*/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) stringBuilders[i] = new StringBuilder();

        int builderIndex = 0, increase = 1;
        for (int i = 0; i < s.length(); i++) {
            stringBuilders[builderIndex].append(s.charAt(i));
            if (builderIndex == 0) increase = 1;
            if (builderIndex == numRows - 1) increase = -1;
            builderIndex += increase;
        }
        
        StringBuilder zigzag = new StringBuilder();
        for (int i = 0; i < numRows; i++) zigzag.append(stringBuilders[i]);
        
        return zigzag.toString();
    }
}