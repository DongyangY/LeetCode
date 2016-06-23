public class Solution {
    
    interface Operator {
        int eval(int x, int y);
    }
    
    private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {
        {
            put("+", new Operator() {
                public int eval(int x, int y) { return x + y; }
            });
            
            put("-", new Operator() {
                public int eval(int x, int y) { return x - y; }
            });
            
            put("*", new Operator() {
                public int eval(int x, int y) { return x * y; }
            });
            
            put("/", new Operator() {
                public int eval(int x, int y) { return x / y; }
            });
        }    
    };
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String o : tokens) {
            if (OPERATORS.containsKey(o)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORS.get(o).eval(x, y));
            } else {
                stack.push(Integer.parseInt(o));
            }
        }
        return stack.pop();
    }
}