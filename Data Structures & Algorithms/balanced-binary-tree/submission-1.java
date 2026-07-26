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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        //for this problem of isBalanced, we can look to calculate the height of each subtree recursively, then compare the depths of each left and right subtree at each node
        //if the diff is > 1, update our global variable to false
        dfs(root);
        return balanced;
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(Math.abs(left - right) > 1) balanced = false;

        return 1 + Math.max(left, right);
    }
}
