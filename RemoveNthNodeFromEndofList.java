/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = head;
        while (j != null) {
            j = j.next;
            if (n == 0) i = i.next;
            else --n;
        }
        i.next = i.next.next;
        return dummy.next;
    }
}