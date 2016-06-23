public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return null;
        
        String r = new String();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        if (numerator < 0 ^ denominator < 0) r += "-";
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        
        r += n / d;
        if (n % d != 0) r += ".";
        int i = r.length();
        while (n % d != 0) {
            long re = n % d;
            if (map.containsKey(re)) {
                int p = map.get(re);
                r = r.substring(0, p) + "(" + r.substring(p, r.length()) + ")";
                break;
            }
            map.put(re, i);
            n = re * 10;
            r += n / d;
            i++;
        }
        
        return r;
    }
}