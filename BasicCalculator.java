public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int k = 0; k < chars.length; k++) {
            char c = chars[k];
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                if (c != ')') {
                    stack.push(String.valueOf(c));
                } else {
                    ArrayList<String> inner = new ArrayList<>();
                    String top = stack.pop();
                    while (!top.equals("(")) {
                        inner.add(top);
                        top = stack.pop();
                    }
                    stack.push(String.valueOf(sum(inner)));
                }
            }
        }
        if (sb.length() > 0) stack.push(sb.toString());
        
        ArrayList<String> inner = new ArrayList<>();
        while (!stack.isEmpty()) {
            inner.add(stack.pop());
        }
        return sum(inner);
    }
    
    private int sum(ArrayList<String> eq) {
        int sum = 0;
        for (int i = 0; i < eq.size() - 1; i += 2) {
            int value = Integer.valueOf(eq.get(i));
            sum += eq.get(i + 1).equals("-") ? -value : value;
        }
        String last = eq.get(eq.size() - 1);
        if (!last.equals("-") && !last.equals("+"))
            sum += Integer.valueOf(eq.get(eq.size() - 1));
        return sum;
    }
}