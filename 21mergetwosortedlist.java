/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            ListNode next = l1.val <= l2.val ? l1:l2;
            p.next = next;
            p = next;
            if (next == l1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        p.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
