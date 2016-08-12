/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode h = new RandomListNode(head.label);
        map.put(head, h);
        RandomListNode p1 = head.next, p2 = h;
        while (p1 != null) {
            p2.next = new RandomListNode(p1.label);
            p2 = p2.next;
            map.put(p1, p2);
            p1 = p1.next;
        }
        p1 = head;
        p2 = h;
        while (p1 != null) {
            RandomListNode rand = p1.random == null ? null : map.get(p1.random);
            p2.random = rand;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return h;
    }
}