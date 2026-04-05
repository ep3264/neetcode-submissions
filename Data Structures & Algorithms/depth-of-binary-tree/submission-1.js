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
        if (!root) return 0;

        const queue = [root];
        let result = 0;
        const counter = new Array(100).fill(0);
        counter[result]++;
        while (queue.length) {

            const node = queue.shift();
            counter[result]--;

            if (counter[result] == 0) {
                result++;
                if (node.left) counter[result]++;
                if (node.right) counter[result]++;
            } else {
                if (node.left) counter[result + 1]++;
                if (node.right) counter[result + 1]++;
            }

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);

        }
        return result;
    
    }
}
