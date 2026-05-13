class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.offer(new int[]{i, j});
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty() && fresh>0) {
            int length = q.size();
            for(int i=0;i<length;i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for(int[] dir: directions) {
                    int nr = row+dir[0], nc = col+dir[1];
                    if(nr>=0 &&nc>=0&&nr<grid.length&&nc<grid[0].length&& grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh==0 ? time : -1;
    }
}
