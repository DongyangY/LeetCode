/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, c = head;
        while (c != null && c.next != null) {
            if (c.val != c.next.val) {
                p = c;
                c = c.next;
            } else {
                while (c.next != null && c.val == c.next.val) 
                    c = c.next;
                c = c.next;
                p.next = c;
            }
        }
        return dummy.next;
    }
}