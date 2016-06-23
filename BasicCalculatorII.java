public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
                    sb.append(chars[i++]);
                }
                i--;
                values.push(Integer.valueOf(sb.toString()));
            } else {
                while (!ops.isEmpty() && !isHighPriority(chars[i], ops.peek())) {
                    values.push(calculate(values.pop(), values.pop(), ops.pop()));
                }
                ops.push(chars[i]);
            }
        }
        
        while (!ops.isEmpty()) {
            values.push(calculate(values.pop(), values.pop(), ops.pop()));
        }
        
        return values.pop();
    }
    
    private Integer calculate(Integer i1, Integer i2, char op) {
        if (op == '+') {
            return i1 + i2;
        } else if (op == '-') {
            return i2 - i1;
        } else if (op == '*') {
            return i1 * i2;
        } else {
            if (i1 == 0) {
                throw new RuntimeException("divided by zero.");
            }
            return i2 / i1;
        }
    }
    
    private boolean isHighPriority(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }
}