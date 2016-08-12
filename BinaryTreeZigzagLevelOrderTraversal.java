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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        LinkedList<Integer> l = new LinkedList<>();
        int i = 0;
        q1.add(root);
        
        while (!q1.isEmpty()) {
            TreeNode top = q1.remove();
            if (top.left != null) q2.add(top.left);
            if (top.right != null) q2.add(top.right);
            if (i % 2 == 0) {
                l.addLast(top.val);
            } else {
                l.addFirst(top.val);
            }
            if (q1.isEmpty()) {
                Queue<TreeNode> q = q1;
                q1 = q2;
                q2 = q;
                res.add(l);
                l = new LinkedList<Integer>();
                i = (i + 1) % 2;
            }
        }
        
        return res;
    }
}