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
        //we have to define what the lowest common ancestor is, 
        //if we are at the root, and it is equal to either p or q, then we return immediately, as the root node is the LCA
        //if we encounter p first, then we need to find q, if it is in one of p's subtrees, return p, if it is not, then it must either be in the same level, or another tree
        //p and q are expected to be in the tree no matter what
        //lets say we find p then if we find q in either of its left or right subtree then we return with p,
        //if we find p, and not in subtree, it is either in the same level, or in another tree outside, so we should just return p value as found
        if(root == null || p == null || q == null){
            return null;
        }
        if(Math.max(p.val, q.val) < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(Math.min(p.val, q.val) > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
