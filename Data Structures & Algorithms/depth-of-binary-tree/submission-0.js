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
     * @return {number}
     */
    maxDepth(root) {
        
        return this.maxDepthRec(root, 0);
    }

    maxDepthRec(root, d) {
        if (!root) return d;

        const l = this.maxDepthRec(root.left, d + 1);
        const r = this.maxDepthRec(root.right, d + 1);

        return l > r ? l : r;
    
    }
}
