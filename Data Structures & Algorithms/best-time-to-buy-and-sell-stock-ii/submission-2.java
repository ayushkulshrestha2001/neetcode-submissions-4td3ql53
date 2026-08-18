class Solution {
    int[][] memo;
    private int profit(int[] prices, int i, int bought) {
        if(i==prices.length) return 0;
        if(memo[i][bought]!=-1) return memo[i][bought];
        int res = profit(prices, i+1, bought);
        if(bought==1) {
            res = Math.max(res, profit(prices, i+1, 0) + prices[i]);
        } else {
            res = Math.max(res, profit(prices, i+1, 1) - prices[i]);
        }
        return memo[i][bought] = res;
    }
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++) {
            memo[i][0]=-1;
            memo[i][1]=-1;
        }
        return profit(prices, 0, 0)
;    }
}