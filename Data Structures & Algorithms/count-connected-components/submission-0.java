class Solution {
    private void bfs(List<List<Integer>> adj, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int nei: adj.get(curr)) {
                if(!visited[nei]) {
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res= 0;
        for(int i =0;i<n;i++) {
            if(!visited[i]) {
                bfs(adj, visited, i);
                res++;
            }
        }
        return res;
    }
}
