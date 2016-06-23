/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    
    public ListNode sort(ListNode begin) {
        if (begin == null || begin.next == null) return begin;
        ListNode mid = begin, fast = begin, end = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) end = mid;
            mid = mid.next;
        }
        end.next = null;
        begin = sort(begin);
        mid = sort(mid);
        return mergeTwoLists(begin, mid);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;
        return dummy.next;
    }
}