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
        TreeNode[] res = new TreeNode[1];
        res[0] = null;
        dfs(root, p, q, res);
        return res[0];
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res) {
        if (root == null) {
            return;
        }

        if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
            res[0] = root;
            return;
        }

        if (p.val < root.val && q.val < root.val) {
            dfs(root.left, p, q, res);
        }

        if (p.val > root.val && q.val > root.val) {
            dfs(root.right, p, q, res);
        }
    }
}
