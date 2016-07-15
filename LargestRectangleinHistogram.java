public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[i] > h[stack.peek()]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                max = Math.max(max, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}