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
        List<Integer> tmp = new ArrayList<>();
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        boolean isLeftToRight = true;
        if (root != null) current.push(root);
        
        while (!current.isEmpty()) {
            TreeNode n = current.pop();
            tmp.add(n.val);
            
            if (isLeftToRight) {
                if (n.left != null) next.push(n.left);
                if (n.right != null) next.push(n.right);
            } else {
                if (n.right != null) next.push(n.right);
                if (n.left != null) next.push(n.left);
            }
            
            if (current.isEmpty()) {
                res.add(tmp);
                tmp = new ArrayList<Integer>();
                current = next;
                next = new Stack<>();
                isLeftToRight = !isLeftToRight;
            }
        }
        
        return res;
    }
}