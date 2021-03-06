/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p;
            } else {
                p2.next = p;
                p2 = p;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
