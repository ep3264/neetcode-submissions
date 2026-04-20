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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n;  i++) {
                var node =  queue.pollFirst();
                if (node.left != null)  queue.addLast(node.left);
                if (node.right != null)  queue.addLast(node.right);

                var temp  = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }

        return root;
    }
}
