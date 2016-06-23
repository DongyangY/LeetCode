public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int na = i >= 0 ? a.charAt(i--) - '0' : 0;
            int nb = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = (na + nb + carry) % 2;
            carry = (na + nb + carry) / 2;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}