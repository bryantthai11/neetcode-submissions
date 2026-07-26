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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null) return false;
        if(q == null) return false;
        if(p.val != q.val) return false;
        //why is this not working? it is only valid, if we finally find both nulls meaning we are at the leaf node and all other values were the same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
