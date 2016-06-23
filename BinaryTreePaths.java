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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if (root != null) addPath(root, lst, "" + root.val);
        return lst;
    }
    
    public void addPath(TreeNode node, List<String> lst, String cur) {
        if (node.left == null && node.right == null) {
            lst.add(cur);
            return;
        }
        if (node.left != null) addPath(node.left, lst, cur + "->" + node.left.val);
        if (node.right != null) addPath(node.right, lst, cur + "->" + node.right.val);
    }
}