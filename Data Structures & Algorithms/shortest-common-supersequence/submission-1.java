public class Solution {
    private int[][] dp;
    private int n, m;

    public String shortestCommonSupersequence(String str1, String str2) {
        n = str1.length();
        m = str2.length();
        dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dfs(0, 0, str1, str2);

        return buildSCS(str1, str2);
    }

    private int dfs(int i, int j, String str1, String str2) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == n) return dp[i][j] = m - j;
        if (j == m) return dp[i][j] = n - i;

        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, str1, str2);
        } else {
            dp[i][j] = 1 + Math.min(dfs(i + 1, j, str1, str2), dfs(i, j + 1, str1, str2));
        }
        return dp[i][j];
    }

    private String buildSCS(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;

        while (i < n || j < m) {
            if (i == n) {
                res.append(str2.substring(j));
                break;
            }
            if (j == m) {
                res.append(str1.substring(i));
                break;
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                res.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] < dp[i][j + 1]) {
                res.append(str1.charAt(i));
                i++;
            } else {
                res.append(str2.charAt(j));
                j++;
            }
        }

        return res.toString();
    }
}