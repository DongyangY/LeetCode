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
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nd = cur.next;
            while (nd != null && cur.val == nd.val) nd = nd.next;
            cur.next = nd;
            cur = nd;
        }
        return head;
    }
}