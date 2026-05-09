/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (root != null) {
            if (root.val <= max && root.val >= min) return root;
            if (root.val > max) root = root.left;
            if (root.val < min) root = root.right;
        }

        return null;
    }
}
