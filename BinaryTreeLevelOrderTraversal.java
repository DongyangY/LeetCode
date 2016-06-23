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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        if (root != null) q1.add(root);
        
        while (!q1.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode n = q1.remove();
                lvl.add(n.val);
                if (n.left != null) q2.add(n.left);
                if (n.right != null) q2.add(n.right);
            }
            res.add(lvl);
            Queue<TreeNode> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }
        return res;
    }
}