class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        for(int i=0;i<nums.length;i++) {
            int cur = nums[i];
            res = Math.max(cur, res);
            for(int j=i+1;j<nums.length;j++) {
                cur = cur + nums[j];
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
