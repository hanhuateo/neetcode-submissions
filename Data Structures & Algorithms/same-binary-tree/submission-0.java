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
        boolean[] res = new boolean[1];
        res[0] = true;
        dfs(p, q, res);
        return res[0];
    }

    public void dfs(TreeNode p, TreeNode q, boolean[] res) {
        if (p == null && q == null) {
            return;
        }

        if (p == null || q == null) {
            res[0] = false;
            return;
        }

        if (p.val != q.val) {
            res[0] = false;
            return;
        }

        dfs(p.left, q.left, res);
        dfs(p.right, q.right, res);
    }
}
