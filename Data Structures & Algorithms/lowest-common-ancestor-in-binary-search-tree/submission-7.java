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
        int max = q.val;
        int min = p.val;
        if (p.val > q.val) {
            max = p.val;
            min = q.val;
        }
        
        while (root != null) {
            if (root.val > max) root = root.left;
            else if (root.val < min) root = root.right;
            else if (root.val <= max && root.val >= min) return root;
        }

        return null;
    }
}
