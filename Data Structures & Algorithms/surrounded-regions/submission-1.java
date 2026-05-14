class Solution {
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        int[][] directions = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j]=='O' && (i==0 || i==r-1 || j==0 || j==c-1)) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            board[row][col] = '#';
            for(int[] d : directions) {
                int nr = row+d[0], nc = col+d[1];
                if(nr>=0 && nc>=0 && nr<r && nc<c && board[nr][nc]=='O') {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                } else if(board[i][j]=='#') {
                    board[i][j]='O';
                }
            }
        }
    }
}
