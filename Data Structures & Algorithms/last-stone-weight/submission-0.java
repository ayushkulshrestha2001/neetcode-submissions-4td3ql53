class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> b - a; 
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        for(int stone: stones) {
            pq.offer(stone);
        }
        while(!pq.isEmpty() && pq.size()!=1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            if(num1 == num2) continue;
            if(num1 < num2) {
                pq.offer(num2-num1);
            } else {
                pq.offer(num1-num2);
            }
        }
        return pq.size()==0 ? 0 : pq.peek();
    }
}
