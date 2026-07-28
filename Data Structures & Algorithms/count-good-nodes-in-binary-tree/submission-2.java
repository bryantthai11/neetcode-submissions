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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root, Integer.MIN_VALUE);
        
    }

    public int dfs(TreeNode node, int currMax){
        if(node == null){
            return 0;
        }

        int count = node.val >= currMax ? 1 : 0;
        int newMax = Math.max(currMax, node.val);

        return count + dfs(node.left, newMax) + dfs(node.right, newMax);
    }
}
