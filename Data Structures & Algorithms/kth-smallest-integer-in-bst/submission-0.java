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
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //we need to do an inorder traversal in order to find the kth element
        if(root == null) return -1;
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode node, int k){
        if(node == null || count >= k) return;

        dfs(node.left, k);

        count ++;
        if(count == k){
            ans = node.val;
        }
        dfs(node.right, k);
        
    }
}
