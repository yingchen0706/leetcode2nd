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
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        k = k%cnt;
        if (k == 0) {
            return head;
        }
        
        p = head;
        ListNode q = head;
        int gap = k;
        while (gap != 0 && q != null) {
            q = q.next;
            gap--;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode tmp = p.next;
        p.next = null;
        q.next = head;
        return tmp;
    }
}
