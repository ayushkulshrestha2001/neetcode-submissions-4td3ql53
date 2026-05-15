class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) q.offer(i);
        }
        int visited = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            res[visited] = curr;
            visited++;
            for(Integer nei: adj.get(curr)) {
                indegree[nei]--;
                if(indegree[nei]==0) {
                    q.offer(nei);
                }
            }
        }
        if(visited==numCourses) {
            return res;
        }
        return new int[0];
    }
}
