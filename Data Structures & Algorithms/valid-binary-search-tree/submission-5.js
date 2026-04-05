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
        return this.isValidBST_DFS(root, -Infinity, Infinity);
    }

    isValidBST_DFS(root, min, max) {
        if (!root) return true;

        return root.val > min && root.val < max && this.isValidBST_DFS(root.left, min, root.val)
            && this.isValidBST_DFS(root.right, root.val, max);
    }
}
