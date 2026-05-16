class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0], v= edge[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=1;i<n+1;i++) {
            if(indegree[i]==1) q.offer(i);
        }
        int[] res = new int[2];
        while(!q.isEmpty()) {
            int curr = q.poll();
            indegree[curr]--;
            for(Integer nei : adj.get(curr)) {
                indegree[nei]--;
                if(indegree[nei]==1) q.offer(nei);
            }
        }
        for(int i=n-1;i>=0;i--) {
            int u = edges[i][0], v = edges[i][1];
            if(indegree[u]==2 && indegree[v]>0) {
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
}
