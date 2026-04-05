/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @param {TreeNode} p
     * @param {TreeNode} q
     * @return {TreeNode}
     */
    lowestCommonAncestor(root, p, q) {
        return this.recur(root, p, q)[0];
    }

    recur(root, p, q) {

        if (!root) return [null, false];

        const [left, lflag] = this.recur(root.left, p, q);
        const [right, rflag] = this.recur(root.right, p, q);

        if (lflag) return [left, true];
        if (rflag) return [right, true];

        if (left !== null && right !== null) return [root, true];

        if (left !== null || right !== null) {
            if (root.val === p.val || root.val === q.val) return [root, true];
            else return left !== null ? [left, false] : [right, false];
        }

        if (root.val === p.val) return [root, false];
        if (root.val === q.val) return [root, false];

        return [null, false];
    }
}
