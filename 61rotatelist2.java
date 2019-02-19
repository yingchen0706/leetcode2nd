/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head;
        int cnt = 1;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        k = k%cnt;
        if (k == 0) {
            return head;
        }
        
        ListNode q = head;
        int gap = cnt - k-1;
        while (gap != 0) {
            q = q.next;
            gap--;
        }
        
        ListNode tmp = q.next;
        q.next = null;
        p.next = head;
        return tmp;
    }
}
