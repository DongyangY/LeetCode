public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int[] c = new int[a.length + b.length];
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                c[i + j] += Character.getNumericValue(a[a.length - i - 1]) * 
                    Character.getNumericValue(b[b.length - j - 1]);
            }
        }
        
        int carry = 0;
        for (int i = 0; i < c.length; i++) {
            int n = c[i] + carry;
            carry = n / 10;
            c[i] = n % 10;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == 0 && !start) continue;
            start = true;
            sb.append(String.valueOf(c[i]));
        }
        
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }
}