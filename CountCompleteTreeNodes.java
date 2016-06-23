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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = 1, rh = 1;
        TreeNode ln = root, rn = root;
        while (ln.left != null) {
            lh++;
            ln = ln.left;
        }
        while (rn.right != null) {
            rh++;
            rn = rn.right;
        }
        if (lh == rh) {
            return (2 << (lh - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}