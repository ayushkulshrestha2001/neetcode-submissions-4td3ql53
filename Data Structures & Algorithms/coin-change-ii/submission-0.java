class Solution {
    int[][] dp;
    private int dfs(int[] coins, int i, int amount) {
        if(amount==0) return 1;
        if(i>=coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];

        int res = 0;
        if(coins[i]<=amount) {
            res=dfs(coins, i+1, amount);
            res+=dfs(coins, i, amount-coins[i]);
        }
        return dp[i][amount]=res;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp = new int[coins.length+1][amount+1];
        for(int[] it:dp) {
            Arrays.fill(it, -1);
        }
        return dfs(coins, 0, amount);
    }
}
