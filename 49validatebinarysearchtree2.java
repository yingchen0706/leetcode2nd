/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidSubTree(root, null, null);
        
    }
    private boolean isValidSubTree(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min !=null &&root.val <= min) {
            return false;
        } 
        if (max != null && root.val >= max) {
            return false;
        }
        return (isValidSubTree(root.left, min, root.val)) && isValidSubTree(root.right, root.val, max);
    }
    
}
