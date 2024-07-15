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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> root = new HashSet<>();
        
        for (int[] description : descriptions) {
            int tempRoot = description[0];
            int child = description[1];
            int isLeft = description[2];
            TreeNode node = nodes.containsKey(tempRoot) ? nodes.get(tempRoot) : new TreeNode(tempRoot);
            TreeNode childNode = nodes.containsKey(child) ? nodes.get(child) : new TreeNode(child);
            
            if (isLeft == 1) {
                node.left = childNode;
            } else {
                node.right = childNode;
            }
            
            nodes.put(tempRoot, node);
            nodes.put(child, childNode);
            root.add(child);
        }
        
        for (int[] description : descriptions) {
            if (!root.contains(description[0])) {
                return nodes.get(description[0]);
            }
        }
        
        return null;
    }
}