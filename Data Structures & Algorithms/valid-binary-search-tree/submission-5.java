// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return true;
//         return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

//     }
    
//     public boolean dfs(TreeNode node, int lowerBound, int upperBound){
//         if(node == null) return true;
//         if(node.val <= lowerBound || node.val >= upperBound){
//             return false;
//         }
//         return dfs(node.left, lowerBound, node.val) && dfs(node.right, node.val, upperBound);
//     }
// }
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
    public boolean isValidBST(TreeNode root) {
        //we have to process the node as we go down, have a helper function that determines if the node looked at satisfies constraints
        //most be in between lower and upper bound, strictly has to be greater than or less than, cannot equal the bounds

        if(root == null){
            return true;
        }

        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public boolean dfs(TreeNode node, int lowerBound, int upperBound){
        if(node == null){
            return true;//we reached the end
        }
        if(node.val <= lowerBound || node.val >= upperBound){
            return false;
        }

        return dfs(node.left, lowerBound, node.val) && dfs(node.right, node.val, upperBound);
    }
    
    
}
