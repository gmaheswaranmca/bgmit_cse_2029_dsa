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
        // Initialize with Long min and max to prevent integer overflow on edge cases
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node, long minimum, long maximum) {
        if (node == null) {
            return true;
        }
        if (node.val <= minimum || node.val >= maximum) {
            return false;
        }
        return validate(node.left, minimum, node.val) && 
               validate(node.right, node.val, maximum);
    }
}