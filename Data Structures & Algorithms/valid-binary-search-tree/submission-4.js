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
     * @return {boolean}
     */
    isValidBST(root) {
        if (!root) true;

        return this.isValidBSTRec(root.left, -Number.MAX_VALUE, root.val)
            && this.isValidBSTRec(root.right, root.val, Number.MAX_VALUE);
    }

    isValidBSTRec(root, min, max) {
        if (!root) return true;

        return root.val > min && root.val < max && this.isValidBSTRec(root.left, min, root.val)
            && this.isValidBSTRec(root.right, root.val, max);
    }
}
