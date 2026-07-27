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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //lets redo this problem, for some reason I am having a hard time figuring this out even though it is a leetcode easy
        //Firstly, if subRoot is null, then return true, as a null subtree, will always be able to be a subtree
        //if root is null, and subroot is not null, then return false
        //do a dfs(helper check here to see if the current node, has the subroot rooted at that node, if so return true here)
        //now, if we reach this point, then we should return the or of isSubtree(root.left, subtree) or isSubtree(root.right, subtree) to check other nodes (both subtrees) of the main tree has the subroot rooted somewhere there

        if(subRoot == null) return true;
        if(root == null) return false; //it is implied subRoot is non null in this case

        if(dfs(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode sub){
        if(node == null && sub == null) return true;
        if(node == null || sub == null) return false;
        if(node.val != sub.val) return false;

        return dfs(node.left, sub.left) && dfs(node.right, sub.right);
    }
}
