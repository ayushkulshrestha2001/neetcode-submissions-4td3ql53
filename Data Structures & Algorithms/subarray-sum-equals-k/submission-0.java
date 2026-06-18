class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res = 0, curSum = 0;
        mp.put(0, 1);
        for(int num : nums) {
            curSum = curSum + num;
            int diff = curSum - k;
            res = res + mp.getOrDefault(diff, 0);
            mp.put(curSum, mp.getOrDefault(curSum, 0)+1);
        }
        return res;
    }
}