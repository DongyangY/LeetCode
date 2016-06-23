/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        count.add(0);
        countUnivalSubtrees(root, count);
        return count.get(0);
    }
    
    public boolean countUnivalSubtrees(TreeNode node, List<Integer> count) {
        if (node == null) return true;
        boolean left = countUnivalSubtrees(node.left, count);
        boolean right = countUnivalSubtrees(node.right, count);
        if (left && right && (node.left == null || node.val == node.left.val) && 
            (node.right == null || node.val == node.right.val)) {
            count.set(0, count.get(0) + 1);
            return true;
        }
        return false;
    }
}