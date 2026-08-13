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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    private boolean dfs(TreeNode root, int targetSum, int curSum) {
        if(root==null) {
            return false;
        }
        curSum = curSum + root.val;
        if(root.right==null && root.left==null) {
            return targetSum==curSum;
        }
        return dfs(root.left, targetSum, curSum) || dfs(root.right, targetSum, curSum);
    }
}