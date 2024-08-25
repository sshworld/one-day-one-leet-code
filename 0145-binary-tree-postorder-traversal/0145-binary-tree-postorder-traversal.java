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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        addNode(root, result);
        
        return result;
    }
    
    private void addNode(TreeNode node, List<Integer> nodeValues) {
        if (node == null) {
            return;
        }
        
        addNode(node.left, nodeValues);
        addNode(node.right, nodeValues);
        
        nodeValues.add(node.val);
    }
}