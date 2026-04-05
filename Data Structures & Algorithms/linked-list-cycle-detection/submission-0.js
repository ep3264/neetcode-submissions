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
     * @return {boolean}
     */
    hasCycle(head) {
        const map = new Map();
        let cur = head;
        let index = 0;
        while (cur != null) {

            if (map.has(cur)) {
                return true;
            }

            map.set(cur, index);
            index++;
            cur = cur.next;
        }

        return false;
    }
}
