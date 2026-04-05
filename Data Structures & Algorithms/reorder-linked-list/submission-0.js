/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {void}
     */
    reorderList(head) {

        this.reorderListRec(head, head);
        return head;
    }

    reorderListRec(cur, head) {
        if (!cur.next) return [cur, head];

        const ret = this.reorderListRec(cur.next, head);
        if (!ret) return null;

        const [second, firts] = ret;
        [firts.next, second.next] = [second, firts.next];

        if (second.next && second === second.next.next) {
            second.next.next = null;
            return null;
        }

        return [cur, second.next];
}
}
