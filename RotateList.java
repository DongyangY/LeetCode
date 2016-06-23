/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode end = head;
        int length = 1;
        while (end.next != null) {
            end = end.next;
            length++;
        }
        ListNode newend = head;
        for (int i = 0; i < length - k % length - 1; i++) newend = newend.next;
        end.next = head;
        ListNode newhead = newend == end ? head : newend.next;
        newend.next = null;
        return newhead;
    }
}