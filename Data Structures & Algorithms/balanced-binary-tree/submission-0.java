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
        if(root == null){
            return true;
        }else{
            int left = dfs(root.left);
            int right = dfs(root.right);
            return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        }
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}
