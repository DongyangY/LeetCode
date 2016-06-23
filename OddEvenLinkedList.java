/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h1 = head, i = head, h2 = head.next, j = head.next;
        while (i.next != null && i.next.next != null) {
            i.next = i.next.next;
            j.next = j.next.next;
            i = i.next;
            j = j.next;
        }
        i.next = h2;
        return h1;
    }
}