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

    public ListNode reorderListRec(ListNode head, ListNode cur) {
        if (cur == null)
            return head;

        ListNode node = reorderListRec(head, cur.next);
        if (node == null) return null;

        if (node == cur || node.next == cur) {
            cur.next = null;
            return null;
        }

        ListNode temp = node.next;
        node.next = cur;
        cur.next = temp;

        return cur.next;
    }

}
