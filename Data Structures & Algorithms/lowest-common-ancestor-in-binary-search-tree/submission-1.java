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
        //if node val is greater than both p and q, then it must be in the left subtree,
        //if node val is less than both p and q, then it must be in right side of binary tree
        //if there is a case where val = p or q, or p and q are not both less than or greater than node val, then we are at a LCA
        if(root == null || p == null || q == null){
            return null;
        }
        if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
