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
     * @return {number[][]}
     */
    levelOrder(root) {
        const result = [];
        if (!root) return result;

        const queue = [];

        queue.push(root);

        while (queue.length) {

            const n = queue.length;
            const levelResult = [];
            for (let i = 0; i < n; i++) {


                const node = queue.shift();
                levelResult.push(node.val);

                if (node.left) queue.push(node.left);
                if (node.right) queue.push(node.right);
            }
            result.push(levelResult);
        }

        return result;
    }
}
