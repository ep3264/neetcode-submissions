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
        
        if (!root) return 0;

        const queue = [root];
        let result = 0;
        const counter = [];

        function inc(n) {
            counter[n] = (counter[n] ?? 0) + 1;
        }

        inc(result);
        while (queue.length) {
            const node = queue.shift();
            counter[result]--;

            if (node.left) {
                queue.push(node.left);
                inc(result + 1);
            }
            if (node.right) {
                queue.push(node.right);
                inc(result + 1);
            }

            if (counter[result] == 0) {
                result++;
            }
        }

        return result;
    }
}
