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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        return (int)closestValueHelper(root, target);
    }
    
    private double closestValueHelper(TreeNode root, double target) {
        double val = (double)root.val;
        if (val == target) {
            return val;
        } else if (val > target) {
            if (root.left == null) return val;
            double left = closestValueHelper(root.left, target);
            return Math.abs(left - target) < Math.abs(val - target) ? left : val;
        } else {
            if (root.right == null) return val;
            double right = closestValueHelper(root.right, target);
            return Math.abs(right - target) < Math.abs(val - target) ? right : val;
        }
    }
}