/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q1 = new LinkedList<>();
        Queue<TreeLinkNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            TreeLinkNode top = q1.remove();
            if (top.left != null) {
                q2.add(top.left);
            }
            if (top.right != null) {
                q2.add(top.right);
            }
            if (!q1.isEmpty()) {
                top.next = q1.peek();
            } else {
                Queue<TreeLinkNode> t = q1;
                q1 = q2;
                q2 = t;
            }
        }
    }
}