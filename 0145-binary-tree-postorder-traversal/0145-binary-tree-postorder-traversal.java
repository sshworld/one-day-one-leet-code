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
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root.val);
        pushStack(root, stack);
        
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
    
    private void pushStack(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return;
        }
        
        if (node.right != null) {
            stack.push(node.right.val);
            pushStack(node.right, stack);
        }
        
        if (node.left != null) {
            stack.push(node.left.val);
            pushStack(node.left, stack);
        }
    }
}