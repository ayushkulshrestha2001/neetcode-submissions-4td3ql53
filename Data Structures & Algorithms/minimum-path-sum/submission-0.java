public class Solution {
    private int[][] dp;

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, grid);
    }

    public int dfs(int r, int c, int[][] grid) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }
        if (r == grid.length || c == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = grid[r][c] + Math.min(dfs(r + 1, c, grid), dfs(r, c + 1, grid));
        return dp[r][c];
    }
}