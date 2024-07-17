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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        List<Integer> toDelete = Arrays.stream(to_delete).boxed().collect(Collectors.toList());
        
        result.add(root);
        deleteNodes(root, toDelete, result);
        
        result.removeAll(Collections.singletonList(null));
        
        return result;
    }
    
    private void deleteNodes(TreeNode node, List<Integer> toDelete, List<TreeNode> nodes) {
        if(toDelete.contains(node.val)) {
            nodes.remove(node);
            nodes.add(node.left);
            nodes.add(node.right);
        }
        
        if (node.left == null && node.right == null) {
            return;
        }
        
        if(node.left != null) {
            deleteNodes(node.left, toDelete, nodes);
            
            if(toDelete.contains(node.left.val)) {
                node.left = null;
            }
        }
        
        if(node.right != null) {
            deleteNodes(node.right, toDelete, nodes);      
        
            if(toDelete.contains(node.right.val)) {
                node.right = null;
            }
        }
        
        return;
    }
}