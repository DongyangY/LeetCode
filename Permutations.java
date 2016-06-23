public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            while (queue.peek().size() == i) {
                List<Integer> top = queue.remove();
                for (int j = 0; j <= top.size(); j++) {
                    List<Integer> item = new ArrayList<>(top);
                    item.add(j, nums[i]);
                    queue.add(item);
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }
}