class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e8);
        dist[k] = 0;
        for(int i=1;i<n+1;i++) {
            for(int[] time: times) {
                int u = time[0], v = time[1], wt = time[2];
                if(dist[u]!=1e8 && dist[u]+wt<dist[v]) {
                    if(i == n) {
                        return -1;
                    }
                    dist[v] = dist[u]+wt;
                }
            }
        }
        int min = 0;
        for(int i=1;i<n+1;i++) {
            if(dist[i]!=1e8) {
                min = Math.max(dist[i], min);
            } else {
                return -1;
            }
        }
        return min;
    }
}
