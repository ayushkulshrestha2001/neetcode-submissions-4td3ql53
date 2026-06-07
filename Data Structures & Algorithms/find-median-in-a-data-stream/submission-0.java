class MedianFinder {
    PriorityQueue<Integer> pq;
    public MedianFinder() {
        pq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
    }
    
    public double findMedian() {
        List<Integer> nList = new ArrayList<>(pq);
        Collections.sort(nList, pq.comparator());
        if(nList.size()%2==0) {
            return (nList.get(nList.size()/2) + nList.get(nList.size()/2-1))/2.0;
        } else {
            return nList.get(nList.size()/2);
        }
    }
}
