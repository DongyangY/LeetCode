/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode n = dummy;
            while (n.next != null && n.next.val < p.val)
                n = n.next;
            ListNode next = p.next;
            p.next = n.next;
            n.next = p;
            p = next;
        }
        return dummy.next;
    }
}