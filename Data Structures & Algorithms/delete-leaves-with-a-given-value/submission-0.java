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
    public boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;
        else{
            TreeNode left = removeLeafNodes(root.left, target);
            TreeNode right = removeLeafNodes(root.right, target);
            if(left == null) root.left = null;
            if(right == null) root.right = null;
            if(isLeaf(root) && root.val == target) return null;
            return root;
        }
    }
}