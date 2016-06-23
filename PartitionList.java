/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode fh1 = new ListNode(0);
        ListNode fh2 = new ListNode(0);
        fh1.next = head;
        
        ListNode prev = fh1, p = head, p2 = fh2;
        
        while (p != null) {
            if (p.val < x) {
                p = p.next;
                prev = prev.next;
            } else {
                p2.next = p;
                prev.next = p.next;
                p = prev.next;
                p2 = p2.next;
            }
        }
        
        p2.next = null;
        prev.next = fh2.next;
        
        return fh1.next;
    }
}