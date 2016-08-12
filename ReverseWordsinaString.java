public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        boolean isSpace = false;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!isSpace) {
                    sb.append(' ');
                    isSpace = true;
                }
            } else {
                isSpace = false;
                int j = i;
                while (j >= 0 && s.charAt(j) != ' ') j--;
                sb.append(s.substring(j + 1, i + 1));
                i = j + 1;
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == ' ') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}