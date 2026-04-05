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

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestRec(root, k)[1];
    }

    public int[] kthSmallestRec(TreeNode root, int k) {
        if (root == null) return new int[]{k, -1};

        var left = kthSmallestRec(root.left, k);
        if (left[0] == -1) return left;
        if (left[0] == 1) {
            return new int[]{-1, root.val};
        }

        var right = kthSmallestRec(root.right, left[0] - 1);
        if (right[0] == -1) return right;

        return new int[]{right[0], -1};
    }
}
