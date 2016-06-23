public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            stack.push(node);
            while (stack.size() >= 3 && 
                   stack.get(stack.size() - 1).equals("#") &&
                   stack.get(stack.size() - 2).equals("#") &&
                   !stack.get(stack.size() - 3).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");   
    }
}