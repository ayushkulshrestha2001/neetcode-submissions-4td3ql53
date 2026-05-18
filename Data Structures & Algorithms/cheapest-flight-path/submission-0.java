class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        for(int i=0;i<=k;i++) {
            int[] temp = dist.clone();
            for(int[] flight : flights) {
                int u = flight[0], v = flight[1], cost = flight[2];
                if(dist[u]!=1e8 && dist[u]+cost<=temp[v]) {
                    temp[v] = dist[u]+cost;
                }
            }
            dist = temp;
        }

        return dist[dst] == 1e8 ? -1 : dist[dst];
    }
}
