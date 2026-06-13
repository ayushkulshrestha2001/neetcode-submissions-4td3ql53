class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majn = n/2;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        for(Integer num : mp.keySet()) {
            if(mp.get(num)>majn) {
                return num;
            }
        }
        return 0;
    }
}