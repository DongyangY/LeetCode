/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = p1.next, h = head.next;
        
        while (p1 != null && p1.next != null) {
            p2 = p1.next;
            ListNode t = p2.next;
            p2.next = p1;
            p1.next = (t == null || t.next == null) ? t : t.next;
            p1 = t;
        }
        
        return h;
    }
}