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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        if (root == null) return l;
        
        TreeNode p = root;
        s.push(p);
        p = p.left;
        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                TreeNode t = s.pop();
                l.add(t.val);
                p = t.right;
            }
        }
        return l;
    }
}