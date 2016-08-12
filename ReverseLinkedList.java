/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p1 = null, p2 = head;
        while (p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        return p1;
    }
}