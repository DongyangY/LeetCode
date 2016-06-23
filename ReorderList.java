/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        
        ListNode p1 = head, p2 = reverse(s);
        
        while (p2.next != null) {
            ListNode p1Next = p1.next, p2Next = p2.next;
            p1.next = p2;
            p1 = p1Next;
            p2.next = p1;
            p2 = p2Next;
        }
    }
    
    public ListNode reverse(ListNode head) {
        ListNode p = null, c = head;
        while (c != null) {
            ListNode next = c.next;
            c.next = p;
            p = c;
            c = next;
        }
        return p;
    }
}