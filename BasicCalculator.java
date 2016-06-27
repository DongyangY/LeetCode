public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        Stack<Integer> value = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for (int k = 0; k < chars.length; k++) {
            if (chars[k] >= '0' && chars[k] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (k < chars.length && chars[k] >= '0' && chars[k] <= '9') {
                    sb.append(chars[k]);   
                    k++;
                }
                value.add(Integer.parseInt(sb.toString()));
                k--;
            } else {
                if (chars[k] == '(') {
                    ops.push(chars[k]);
                } else if (chars[k] != ')') {
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        value.push(calculate(value.pop(), value.pop(), ops.pop()));
                    }
                    ops.push(chars[k]);
                } else {
                    while (ops.peek() != '(') {
                        value.push(calculate(value.pop(), value.pop(), ops.pop()));
                    }
                    ops.pop();
                }
            }
        }
        while (!ops.isEmpty()) {
            value.push(calculate(value.pop(), value.pop(), ops.pop()));
        }
        return value.pop();
    }
    
    private int calculate(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else {
            return v2 - v1;
        }
    }
}