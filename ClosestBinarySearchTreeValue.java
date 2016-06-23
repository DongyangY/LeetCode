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
        TreeNode closest = root, n = root;
        double distance = Double.MAX_VALUE;
        while (n != null) {
            double d = Math.abs(target - n.val);
            if (d < distance) {
                distance = d;
                closest = n;
            }
            if (n.val == target) return n.val;
            else if (n.val < target) n = n.right;
            else n = n.left;
        }
        return closest.val;
    }
}