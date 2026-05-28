class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();
    private int dfs(int[] nums, int i) {
        if(i>=nums.length-1) {
            return 0;
        }
        if(mp.containsKey(i)) return mp.get(i);
        int cur = Integer.MAX_VALUE;
        for(int k=1;k<=nums[i];k++) {
            int next = dfs(nums, i + k);

            // avoid overflow
            if (next != Integer.MAX_VALUE) {
                cur = Math.min(cur, 1 + next);
            }
        }
        mp.put(i, cur);
        return cur;
    }
    public int jump(int[] nums) {
        return dfs(nums, 0);
    }
}
