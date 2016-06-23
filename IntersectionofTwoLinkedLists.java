/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = 0, lb = 0;
        ListNode a = headA, b = headB;
        while (a != null) {
            a = a.next;
            la++;
        }
        while (b != null) {
            b = b.next;
            lb++;
        }
        if (la < lb) {
            int diff = lb - la;
            while (diff-- > 0) headB = headB.next;
        } else {
            int diff = la - lb;
            while (diff-- > 0) headA = headA.next;
        }
        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}