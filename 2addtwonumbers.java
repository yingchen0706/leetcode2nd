/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode q = head;
        int a, b;
        
        while (p1 != null || p2 != null) {
            int sum = add;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            q.next = new ListNode(sum>=10 ? sum - 10 : sum);
            q = q.next;
            add = sum/10;
        }
        if (add >0) {
            q.next = new ListNode(add);
        }
        return head.next;
    }
}
