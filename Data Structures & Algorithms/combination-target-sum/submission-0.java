class Solution {
    private void dfs(int[] nums, int target, int i, int sum, List<Integer> comb, List<List<Integer>> res) {
        if(sum>target) return;
        if(sum==target) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if(i>=nums.length) {
            return;
        }
        comb.add(nums[i]);
        // pick (allow reuse → same index)
        dfs(nums, target, i, sum + nums[i], comb, res);
        comb.remove(comb.size()-1);
        // skip
        dfs(nums, target, i+1, sum, comb, res);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(nums, target, 0, 0, comb, res);
        return res;
    }
}
