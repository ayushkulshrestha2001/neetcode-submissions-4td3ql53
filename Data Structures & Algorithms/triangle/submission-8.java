public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][];
        int INF = Integer.MAX_VALUE;
        for (int r = 0; r < triangle.size(); r++) {
            memo[r] = new int[triangle.get(r).size()];
            Arrays.fill(memo[r], INF);
        }

        return dfs(0, 0, triangle, memo);
    }

    private int dfs(int row, int col, List<List<Integer>> triangle, int[][] memo) {
        if (row >= triangle.size()) {
            return 0;
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        memo[row][col] = triangle.get(row).get(col) + Math.min(dfs(row + 1, col, triangle, memo), dfs(row + 1, col + 1, triangle, memo));
        return memo[row][col];
    }
}