class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            int j = i;
            while(sum<target && j<nums.length) {
                sum += nums[j++];
            }
            int len = j-i;
            if(len<res && sum>=target) {
                res = len;
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}