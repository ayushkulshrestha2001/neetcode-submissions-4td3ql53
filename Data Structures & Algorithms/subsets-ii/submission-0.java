class Solution {

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
        res.add(new ArrayList<>(subset));

        for(int j=i;j<nums.length;j++) {
            if(j>i && nums[j]==nums[j-1]) continue;
            subset.add(nums[j]);
            dfs(nums, j+1, res, subset);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }
}
