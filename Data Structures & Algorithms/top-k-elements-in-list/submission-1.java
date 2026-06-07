class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(Integer n : freq.keySet()) {
            minHeap.offer(new int[]{n, freq.get(n)});
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int i =0;
        while(!minHeap.isEmpty()) {
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
