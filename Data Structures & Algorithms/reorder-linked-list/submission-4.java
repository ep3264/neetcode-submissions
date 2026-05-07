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
        if (head == null || head.next == null)
            return;

        reorderListRec(head, head.next);
    }

    public ListNode reorderListRec(ListNode head, ListNode cur) {
        if (cur.next == null) {
            cur.next = head.next;
            head.next = cur;
            return cur.next;
        }

        var ret = reorderListRec(head, cur.next);
        if (ret == null) return null;
        var temp = ret.next;

        if (cur == ret) {
            cur.next = null;
            return  null;
        }

        if (cur.next == temp) {
            temp.next = null;
            return null;
        }
        ret.next = cur;
        cur.next = temp;



        return temp;
    }
}
