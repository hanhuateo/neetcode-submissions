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
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, boolean[] res) {
        if (root == null) {
            return 0;
        }

        int leftHeight = dfs(root.left, res);
        int rightHeight = dfs(root.right, res);
        System.out.println("left : " + leftHeight);
        System.out.println("right : " + rightHeight);
        System.out.println("val : " + root.val);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            res[0] = res[0] && false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
