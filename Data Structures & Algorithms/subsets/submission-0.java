class Solution {
    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if(i>=nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i+1, subset, res);
        subset.remove(subset.size()-1);
        dfs(nums, i+1, subset, res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }
}
