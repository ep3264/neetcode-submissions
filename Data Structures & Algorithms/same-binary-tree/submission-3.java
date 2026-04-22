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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p.val != q.val) return false;

            if (p.left != null && q.left != null) {
                queue.offer(p.left);
                queue.offer(q.left);
            } else if (!(p.left == null && q.left == null)) return false;

            if (p.right != null && q.right != null) {
                queue.offer(p.right);
                queue.offer(q.right);
            } else if (!(p.right == null && q.right == null)) return false;

        }

        return true;
    }
}
