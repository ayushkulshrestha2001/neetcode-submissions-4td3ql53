class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        int[] nums1 = new int[n - 1]; // exclude last
        int[] nums2 = new int[n - 1]; // exclude first

        for(int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }

        for(int i = 1; i < n; i++) {
            nums2[i - 1] = nums[i];
        }

        int n1 = helper(nums1);
        int n2 = helper(nums2);

        return Math.max(n1, n2);
    }

    private int helper(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}