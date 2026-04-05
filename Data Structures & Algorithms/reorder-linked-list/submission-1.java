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
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        reorderListRec(head, head.next);
    }

    public ListNode reorderListRec(ListNode head, ListNode curr) {
        if (curr == null)
            return head;

        ListNode node = reorderListRec(head, curr.next);
        if (node == null) return null;

        ListNode temp = node.next;
        node.next = curr;
        curr.next = temp;

        if (curr.next != null && curr.next.next == curr) {
            curr.next.next = null;
        }

        return curr.next;
    }

}
