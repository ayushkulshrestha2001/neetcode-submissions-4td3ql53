class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    private int dfs(int nums[], int target, int i, int sum) {
        if(i==nums.length) {
            return target==sum ? 1:0;
        }
        String key = i + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ways = dfs(nums, target, i+1, sum+nums[i]) + dfs(nums, target, i+1, sum-nums[i]);
        memo.put(key, ways);
        return ways;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
}
