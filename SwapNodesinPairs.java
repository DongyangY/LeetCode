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
        ListNode last = head, p = head;
        while (p != null && p.next != null) {
            ListNode tmp = p.next;
            last.next = tmp;
            if (head == p) head = tmp;
            p.next = p.next.next;
            tmp.next = p;
            last = p;
            p = p.next;
        }
        return head;
    }
}