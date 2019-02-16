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
        
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        LinkedList<Integer> lower_limit = new LinkedList<>();
        lower_limit.offer(null);
        LinkedList<Integer> upper_limit = new LinkedList<>();
        upper_limit.offer(null);
        

        
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            Integer lower = lower_limit.poll();
            Integer upper = upper_limit.poll();
            
            if (node.left != null) {
                if (node.left.val < node.val) {
                    if (lower != null && node.left.val <= lower) {
                        return false;
                    }
                    list.offer(node.left);
                    lower_limit.offer(lower);
                    upper_limit.offer(node.val);
                } else {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.right.val > node.val) {
                    if (upper != null && node.right.val >= upper) {
                        return false;
                    }
                    list.offer(node.right);
                    lower_limit.offer(node.val);
                    upper_limit.offer(upper);
                } else {
                    return false;
                }
            }
            

        }
        return true;
         
    }
}
