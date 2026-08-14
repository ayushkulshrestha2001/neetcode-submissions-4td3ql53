class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return res >= 1e9 ? -1 : res;
    }
    private int dfs(int[] coins, int amount) {
        if(amount==0) return 0;
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int res = (int)1e9;
        for(int i=0;i<coins.length;i++) {
            if(amount-coins[i]>=0) {
                res = Math.min(1+dfs(coins, amount-coins[i]), res);
            }
        }
        memo.put(amount, res);
        return res;
    }
}
