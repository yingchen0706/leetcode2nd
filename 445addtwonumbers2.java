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
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        
        int diff = Math.abs(len1 - len2);
        if (diff > 0) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = dummyHead;
            while (diff > 0) {
                p.next = new ListNode(0);
                p = p.next;
                diff--;
            }
            if (len1 > len2) {
                p.next = l2;
                l2 = dummyHead.next;
            } else {
                p.next = l1;
                l1 = dummyHead.next;
            }
        }
        ListNode head = addTwoSub(l1, l2);
        if (head.val >= 10) {
            head.val = head.val - 10;
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    
    private ListNode addTwoSub(ListNode p1, ListNode p2) {
        if (p1.next == null) {
            ListNode p = new ListNode(p1.val + p2.val);
            return p;
        }
        ListNode p = addTwoSub(p1.next, p2.next);
        int add = 0;
        if (p.val >= 10) {
            p.val = p.val - 10;
            add=1;
        }
        ListNode newHead = new ListNode(p1.val + p2.val + add);
        newHead.next = p;
        return newHead;
    }
    
    private int getLen(ListNode head) {
        int i = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }
}
