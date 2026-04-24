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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        deque.offer(root);

        while(!deque.isEmpty()){
            int len = deque.size();
            List<Integer> currlist = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode elenode = deque.removeFirst();
                currlist.add(elenode.val);
                if(elenode.left != null){
                    deque.addLast(elenode.left);
                }
                if(elenode.right != null){
                    deque.addLast(elenode.right);
                }
            }
            retList.add(currlist);
        }
        return retList;
    }
}
