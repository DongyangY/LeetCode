/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = 1;
        while (k <= lists.length - 1) {
            for (int i = 0; i < lists.length; i += 2 * k) {
                lists[i] = (i + k <= lists.length - 1) ? mergeTwoLists(lists[i], lists[i + k]) : mergeTwoLists(lists[i], null);
            }
            k *= 2;
        }
        return lists.length == 0 ? null : lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return head.next;
    }
}