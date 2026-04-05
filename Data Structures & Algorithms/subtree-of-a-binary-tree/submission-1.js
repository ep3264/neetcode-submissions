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
     * @param {TreeNode} subRoot
     * @return {boolean}
     */

    isSubtree(root, subRoot) {
        if (!root && !subRoot) return true;

        if (!root || !subRoot) return false;

        let ret = this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
        ret = ret || this.isSubtreeRec(root, subRoot);


        return ret;
    }

    isSubtreeRec(root, subRoot) {
        if (!root && !subRoot) return true;

        if (!root || !subRoot) return false;

        if (root.val == subRoot.val) {
            const left = this.isSubtreeRec(root.left, subRoot.left);
            const right = this.isSubtreeRec(root.right, subRoot.right);

            return left && right;
        }

        return false;
    }
}
