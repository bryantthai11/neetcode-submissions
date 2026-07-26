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
//     public TreeNode invertTree(TreeNode root) {
//         //I can think of doing this two ways one with dfs, the smaller problem, is at each node, swap the right and left child, base case, if node is null, just return null.
//         //you can also do a bfs, where you offer the root, then swap each of the left and right node, only put back into the queue if the children node is none null, return root as ans
//         if(root == null) return null;

//         TreeNode tmp = root.left;
//         root.left = root.right;
//         root.right = tmp;

//         invertTree(root.left);
//         invertTree(root.right);

//         return root;
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
    public TreeNode invertTree(TreeNode root) {
        //I can think of doing this two ways one with dfs, the smaller problem, is at each node, swap the right and left child, base case, if node is null, just return null.
        //you can also do a bfs, where you offer the root, then swap each of the left and right node, only put back into the queue if the children node is none null, return root as ans
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                //I stopped here to think, hould i add to the queue before the swap or after, upon consideration it should be after the swap, as we are building form top down
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;

    }
}
