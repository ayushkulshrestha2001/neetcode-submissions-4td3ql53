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
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            res.add(new ArrayList<>());
            for(int i=0;i<len;i++) {
                TreeNode ele = q.poll();
                res.get(level).add(ele.val);
                if(ele.left!=null) {
                    q.offer(ele.left);
                }
                if(ele.right!=null) {
                    q.offer(ele.right);
                }
            }
            level++;
        }
        return res;
    }
}
