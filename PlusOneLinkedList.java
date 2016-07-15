/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode t = head;
        while (t != null) {
            stack.push(t);
            t = t.next;
        }
        
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            if (top.val < 9) {
                top.val++;
                return head;
            } else {
                top.val = 0;
            }
        }
        
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return newHead;
    }
}