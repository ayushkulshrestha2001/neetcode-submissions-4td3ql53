class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            numSet.add(nums[i]);
        }
        int maxCount = 0;
        for(int i=0;i<nums.length;i++) {
            int count = 0;
            int num = nums[i];
            while(numSet.contains(num)) {
                num++;
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
