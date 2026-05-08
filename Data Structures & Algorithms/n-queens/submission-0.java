class Solution {

    private void backtrack(int n, int col,
                           List<List<String>> res,
                           List<String> board,
                           boolean[] rows,
                           boolean[] diag1,
                           boolean[] diag2) {

        if(col == n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row < n; row++) {

            if(!rows[row] &&
               !diag1[row + col] &&
               !diag2[row - col + n]) {

                rows[row] = true;
                diag1[row + col] = true;
                diag2[row - col + n] = true;

                // place queen
                char[] currRow = board.get(row).toCharArray();
                currRow[col] = 'Q';
                board.set(row, new String(currRow));

                backtrack(n, col + 1, res, board,
                          rows, diag1, diag2);

                // remove queen
                currRow[col] = '.';
                board.set(row, new String(currRow));

                rows[row] = false;
                diag1[row + col] = false;
                diag2[row - col + n] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        List<String> board = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        boolean[] rows = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(n, 0, res, board, rows, diag1, diag2);

        return res;
    }
}