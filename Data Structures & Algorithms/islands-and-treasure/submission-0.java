class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};

    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0;k<size;k++) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];
                if(grid[row][col]==0) return steps;
                for(int[] dir: directions) {
                    int nr = row+dir[0], nc = col+dir[1];
                    if(nr>=0 && nc>=0 &&nr<grid.length && nc<grid[0].length && !visited[nr][nc] && grid[nr][nc]!=-1) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }
    public void islandsAndTreasure(int[][] grid) {
        int inf = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == inf) {
                    grid[i][j] = bfs(grid, i, j);
                }
            }
        }
    }
}
