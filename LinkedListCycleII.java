/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head, s = head, joint = null;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                joint = s;
                break;
            }
        }
        if (joint == null) return null;
        while (head != s) {
            head = head.next;
            s = s.next;
        }
        return head;
    }
}