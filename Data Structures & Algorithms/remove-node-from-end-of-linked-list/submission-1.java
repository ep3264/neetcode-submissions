/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null && n == 1) return null;

        var dummy = new ListNode(-1, head);
        removeNthFromEndRec(dummy, n);
        
        return dummy.next;
    }

    private int removeNthFromEndRec(ListNode head, int n) {
        if (head == null) return n;

        var counter = removeNthFromEndRec(head.next, n);
        if (counter == 0) {
            ListNode node = null;
            if (head.next != null) {
                node = head.next.next;
            }
            head.next = node;
        }

        return counter - 1;
    }
}
