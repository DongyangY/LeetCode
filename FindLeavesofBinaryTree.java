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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            if (findLeaves(root, temp)) {
                root = null;
            }
            result.add(temp);
        }
        return result;
    }
    
    private boolean findLeaves(TreeNode root, List<Integer> temp) {
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            return true;
        }
        
        if (root.left != null) {
            if (findLeaves(root.left, temp)) {
                root.left = null;
            }
        }
        
        if (root.right != null) {
            if (findLeaves(root.right, temp)) {
                root.right = null;
            }
        }
        
        return false;
    }
}