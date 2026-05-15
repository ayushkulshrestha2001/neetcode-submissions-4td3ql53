class Solution {

    public boolean validTree(int n, int[][] edges) {

        // tree must have exactly n-1 edges
        if(edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int count = 0;

        while(!q.isEmpty()) {

            int curr = q.poll();

            if(visited[curr]) continue;

            visited[curr] = true;
            count++;

            for(int nei : adj.get(curr)) {
                if(!visited[nei]) {
                    q.offer(nei);
                }
            }
        }

        return count == n;
    }
}