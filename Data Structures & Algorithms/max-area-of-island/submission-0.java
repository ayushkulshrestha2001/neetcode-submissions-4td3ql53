class Solution {
    private void dfs(int[][] grid, int i, int j, int[] area) {
        if(i<0 || j<0 || i>=grid.length ||j>=grid[0].length || grid[i][j]==0) {
            return;
        }
        grid[i][j] = 0;
        area[0] = area[0]+1;
        dfs(grid, i+1, j, area);
        dfs(grid, i-1, j, area);
        dfs(grid, i, j+1, area);
        dfs(grid, i, j-1, area);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i< grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    int[] area = new int[1];
                    dfs(grid, i, j, area);
                    if(area[0]>maxArea) {
                        maxArea = area[0];
                    }
                }
            }
        }
        return maxArea;
    }
}
