class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: hand) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(count.keySet());
        while(!pq.isEmpty()) {
            int first = pq.peek();
            for(int i = first;i<first+groupSize;i++) {
                if(!count.containsKey(i)) {
                    return false;
                }
                count.put(i, count.get(i)-1);
                if(count.get(i)==0){
                    if(i!=pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
