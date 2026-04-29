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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> lo = new ArrayList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            lo.add(new ArrayList<>());
            for(int i=0;i<len;i++ ){
                TreeNode ele = q.poll();
                lo.get(level).add(ele.val);
                if(ele.left!=null){
                    q.offer(ele.left);
                }
                if(ele.right!=null){
                    q.offer(ele.right);
                }
            }
            level++;
        }
        System.out.println(lo);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<lo.size();i++) {
            List<Integer> tem = lo.get(i);
            res.add(tem.get(tem.size()-1));
        }
        return res;
    }
}
