class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0;i<=nums.length;i++) {
            buckets.add(new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int num : map.keySet()) {
            int freq = map.get(num);
            buckets.get(freq).add(num);
        }
        int[] arr = new int[k];
        int index = 0;
        for(int i=buckets.size()-1;i>0&&index<k;i--) {
            for(int n : buckets.get(i)) {
                arr[index++] = n;
                if(index==k) return arr;
            }
        }
        return arr;
    }
}
