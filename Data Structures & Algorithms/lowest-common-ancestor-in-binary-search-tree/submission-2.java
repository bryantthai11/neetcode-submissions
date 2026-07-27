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
        //so for this problem, we have to find the lowest common ancestor, 
        //if we start at the root node, and work our way down, we can see that there are three possibilities, if the value of the node
        //we are currently at exceeds both p and q, then p and q must be in the left subtree
        //if the node val is less than both p and q, then the lca must be in the right subtree
        //if node val = p or q, or if node val > p and node val < q then it must be the descendant
        if(root == null || p == null || q == null){
            return null;// not possible
        }

        if(root.val > Math.max(p.val, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < Math.min(p.val, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         //if node val is greater than both p and q, then it must be in the left subtree,
//         //if node val is less than both p and q, then it must be in right side of binary tree
//         //if there is a case where val = p or q, or p and q are not both less than or greater than node val, then we are at a LCA
//         if(root == null || p == null || q == null){
//             return null;
//         }
//         if(root.val > Math.max(p.val, q.val)){
//             return lowestCommonAncestor(root.left, p, q);
//         }else if(root.val < Math.min(p.val, q.val)){
//             return lowestCommonAncestor(root.right, p, q);
//         }else{
//             return root;
//         }
//     }
// }
