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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        find(root,startValue,s1);
        find(root,destValue,s2);
      
        int i = 0;
        int j = 0;
      
        while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)){
            i++;
            j++;
        }

        s1 = new StringBuilder(s1.toString().substring(i));
        s2 = new StringBuilder(s2.toString().substring(j));
        
        StringBuilder result = new StringBuilder();
        
        result.append("U".repeat(s1.length()));
        result = result.append(s2.toString());
        
        return result.toString();

    }
    
    private boolean find(TreeNode root, int num, StringBuilder sb){
        if(root.val == num) {
            return true;
        }
        if(root.left!=null && find(root.left, num, sb)){
            sb.insert(0,"L");
        }else if(root.right != null && find(root.right, num, sb)){
            sb.insert(0,"R");
        }

        return sb.length()>0;
    }
}