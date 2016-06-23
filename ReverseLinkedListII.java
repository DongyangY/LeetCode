/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, prev = null, p = dummy;
        int cnt = 0;
        while (cnt < n) {
            ListNode next = curr.next;
            if (cnt == m - 1 && prev != null) p = prev;
            if (cnt >= m) curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        p.next.next = curr;
        p.next = prev;  
        return dummy.next;
    }
}