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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //isnt this just the node + max of left side and right side, this will explore all paths within the tree
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftPath = Math.max(0, dfs(node.left));
        int rightPath = Math.max(0, dfs(node.right));
        max = Math.max(max, node.val + leftPath + rightPath);
        return node.val + Math.max(leftPath, rightPath);
    }


}
