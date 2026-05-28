class Solution {
    HashMap<Integer, Boolean> mp = new HashMap<>();
    private boolean dfs(int[] nums, int i) {
        if(i==nums.length-1) {
            return true;
        }
        if(mp.containsKey(i)) return mp.get(i);
        for(int k=1;k<=nums[i];k++) {
            if(dfs(nums, i+k)) {
                mp.put(i, true);
                return true;
            }
        }
        mp.put(i, false);
        return false;
    }
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
}
