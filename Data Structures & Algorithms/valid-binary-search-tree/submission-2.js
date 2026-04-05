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
    /**
     * @param {TreeNode} root
     * @return {boolean}
     */
    isValidBST(root) {
        const newRoot = this.buildTree(root);

        return this.isSameTree(root, newRoot);
    }

    buildTree(root) {
        if (!root) return null;
        const newRoot = new TreeNode(root.val);
        this.addNodes(root.left, newRoot);  // skip root itself, it's already added
        this.addNodes(root.right, newRoot);
        return newRoot;
    }

    addNodes(src, dst) {
        if (!src) return;
        this.addNode(dst, src.val);         // insert current node's value into BST
        this.addNodes(src.left, dst);       // dst forwarded correctly
        this.addNodes(src.right, dst);
    }

    addNode(dst, val) {
        if (val < dst.val) {
            if (!dst.left) dst.left = new TreeNode(val);  // found the spot
            else this.addNode(dst.left, val);     // keep searching
        }         if (val < dst.val) {
            if (!dst.left) dst.left = new TreeNode(val);  // found the spot
            else this.addNode(dst.left, val);     // keep searching
        } else if (val > dst.val) {
            if (!dst.right) dst.right = new TreeNode(val);
            else this.addNode(dst.right, val);
        } 
    }

    isSameTree(a, b) {
        // Both null → equal
        if (!a && !b) return true;

        // One null, one not → not equal
        if (!a || !b) return false;

        // Values differ → not equal
        if (a.val !== b.val) return false;

        // Recurse into both subtrees
        return this.isSameTree(a.left, b.left) &&
            this.isSameTree(a.right, b.right);
    }
}
