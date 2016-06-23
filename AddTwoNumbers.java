/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            current.next = new ListNode(0);
            current = current.next;
            carry = addTwoDigits(current, (l1 == null) ? 0 : l1.val, (l2 == null) ? 0 : l2.val, carry);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
                
        return head.next;
    }
    
    public int addTwoDigits(ListNode current, int v1, int v2, int carry) {
        int sum = v1 + v2 + carry;
        current.val = sum % 10;
        return sum >= 10 ? 1 : 0;
    }
}