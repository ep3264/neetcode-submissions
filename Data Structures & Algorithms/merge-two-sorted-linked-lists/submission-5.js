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
     * @param {ListNode} list1
     * @param {ListNode} list2
     * @return {ListNode}
     */
    mergeTwoLists(list1, list2) {

        if (!list1) return list2;
        if (!list2) return list1;

        const ret = list1.val <= list2.val ? list1 : list2;
        let p1 = list1;
        let p2 = list2;
        let prev = null;

        while ((prev || p1) && p2) {
            if (!p1 || p1.val > p2.val) {
                const temp = p1;
                if (prev) prev.next = p2;
                p1 = p2;
                p2 = temp;
            }
            prev = p1;
            p1 = p1.next;

        }

        return ret;
    }
}
