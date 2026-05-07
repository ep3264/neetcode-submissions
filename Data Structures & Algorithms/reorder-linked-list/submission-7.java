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
        if (cur == null) return head;

        var ret = reorderListRec(head, cur.next);
        if (ret == null) return null;
        var next = ret.next;

        if (ret == cur || ret.next == cur) {
            cur.next = null;
            return  null;
        }

        ret.next = cur;
        cur.next = next;

        return next;
    }
}
