class Solution {

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // base case
        if(index == word.length()) return true;

        // boundary + mismatch check
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
           || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        // explore 4 directions
        boolean found = backtrack(board, word, i+1, j, index+1) ||
                        backtrack(board, word, i-1, j, index+1) ||
                        backtrack(board, word, i, j+1, index+1) ||
                        backtrack(board, word, i, j-1, index+1);

        board[i][j] = temp; // backtrack

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}