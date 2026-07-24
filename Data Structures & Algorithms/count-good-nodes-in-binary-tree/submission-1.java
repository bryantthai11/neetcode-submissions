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
        if(root == null) return 0;
        //you are classified as a good node, if from any path of the tree, from root to x node, there are no values greater than x
        //just keep track of the curr max value, and then do dfs on the tree to count the good nodes
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int max){
        if(node == null) return 0;
        int count = 0;
        if(node.val >= max){
            count++;
        }
        return count + dfs(node.left, Math.max(node.val, max)) + dfs(node.right, Math.max(node.val, max));
    }
}
