class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int l = i+1, r = nums.length-1;
            int reqSum = 0-nums[i];
            while(l<r) {
                if(nums[r]+nums[l]==reqSum) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if(nums[r]+nums[l]<reqSum) {
                    l++;
                } else if(nums[r]+nums[l]>reqSum){
                    r--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
