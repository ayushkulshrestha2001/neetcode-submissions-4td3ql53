public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        Arrays.sort(envelopes, (a, b) ->
            a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(b[1], a[1])
        );

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(heights, i, memo));
        }
        return result;
    }

    private int dfs(int[] nums, int i, int[] memo) {
        if (memo[i] != -1) return memo[i];
        int lis = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                lis = Math.max(lis, 1 + dfs(nums, j, memo));
            }
        }
        memo[i] = lis;
        return lis;
    }
}