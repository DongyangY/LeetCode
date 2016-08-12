public class Solution {
    class Node {
        int val, count;
        Node left, right;
        public Node(int val) {
            count = 1;
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        int n = nums.length;
        Node root = new Node(nums[n - 1]);
        res.add(0);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = 0;
            Node p = root;
            while (true) {
                if (nums[i] > p.val) {
                    count += p.count;
                    if (p.right == null) {
                        p.right = new Node(nums[i]);
                        break;
                    }
                    p = p.right;
                } else {
                    p.count++;
                    if (p.left == null) {
                        p.left = new Node(nums[i]);
                        break;
                    }
                    p = p.left;
                }
            }
            res.add(count);
        }
        
        Collections.reverse(res);
        return res;
    }
}