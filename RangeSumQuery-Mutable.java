public class NumArray {

    class TreeNode {
        int start, end;
        int sum;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
    
    TreeNode root;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.root = buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(start, end, nums[start]);
        }
        
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(nums, start, mid);
        TreeNode right = buildTree(nums, mid + 1, end);
        TreeNode node = new TreeNode(start, end, left.sum + right.sum);
        node.left = left;
        node.right = right;
        
        return node;
    }

    public void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    private void updateHelper(TreeNode node, int i, int val) {
        if (node.start == i && node.end == i) {
            node.sum = val;
            return;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            updateHelper(node.left, i, val);
        } else {
            updateHelper(node.right, i, val);
        }
        
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
    
    private int sumRangeHelper(TreeNode node, int i, int j) {
        if (j < node.start || i > node.end) return 0;
        if (node.start >= i && node.end <= j) {
            return node.sum;
        }
        return sumRangeHelper(node.left, i, j) + sumRangeHelper(node.right, i, j);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);