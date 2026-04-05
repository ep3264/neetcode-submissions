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
        if (!root) return true;
        return this.isValidBSTRec(root, root.left) && this.isValidBSTRec(root, root.right);
    }

    isValidBSTRec(root, node) {
        if (!node) return true;

        if (!this.findNode(root, node)) return false;

        return this.isValidBSTRec(root, node.left) && this.isValidBSTRec(root, node.right);
    }

    /**
     * @param {TreeNode} root
     * @param {TreeNode} node
     * @return {boolean}
     */
    findNode(root, node) {
        if (!root) return false;

        if (root == node) return true;

        if (root.val > node.val) return this.findNode(root.left, node);
        if (root.val < node.val) return this.findNode(root.right, node);

        return false;
    }
}
