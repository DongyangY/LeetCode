public class Solution {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        boolean sign = true;
        int i = 0;
        
        while (i < str.length() && str.charAt(i) == ' ') i++;
        
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+' ? true : false;
            i++;
        }
        
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sb.append(str.charAt(i++));
        }

        if (sb.length() != 0) return stoi(sb.toString(), sign);
        else return 0;
    }
    
    public int stoi(String s, boolean sign) {
        Integer maxVal = new Integer(Integer.MAX_VALUE);
        if (s.length() > maxVal.toString().length()) 
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        
        int base = 1, result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = (int)(s.charAt(i) - '0');
            int b = 0;
            
            if (sign) {
                if (n > Integer.MAX_VALUE / base) return Integer.MAX_VALUE;
                b = base * n;
                if (result > Integer.MAX_VALUE - b) return Integer.MAX_VALUE;
            } else {
                n = -n;
                if (n < Integer.MIN_VALUE / base) return Integer.MIN_VALUE;
                b = base * n;
                if (result < Integer.MIN_VALUE - b) return Integer.MIN_VALUE;
            }
            
            result += b;
            base *= 10;
        }
        return result;
    }
}