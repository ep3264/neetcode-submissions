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
     * @return {ListNode}
     */
    reverseList(head) {
        let prev = null;
        let cur = head
        let next = head?.next;

        while (cur) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next?.next
        }

        return prev;
    }
}
