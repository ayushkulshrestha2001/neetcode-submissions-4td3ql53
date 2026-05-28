class Solution {
    private boolean dfs(int[] nums, int i) {
        if(i==nums.length-1) {
            return true;
        }
        for(int k=1;k<=nums[i];k++) {
            if(dfs(nums, i+k)) {
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
}
