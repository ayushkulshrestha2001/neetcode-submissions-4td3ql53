class Solution {
    private int dfs(int nums[], int target, int i, int sum) {
        if(i==nums.length) {
            return target==sum ? 1:0;
        }

        return dfs(nums, target, i+1, sum+nums[i]) + dfs(nums, target, i+1, sum-nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
}
