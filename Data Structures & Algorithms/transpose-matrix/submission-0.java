class Solution {
    public int[][] transpose(int[][] matrix) {
        int r1 = matrix.length;
        int c1 = matrix[0].length;

        int[][] res = new int[c1][r1];

        for(int i=0;i<r1;i++) {
            for(int j=0;j<c1;j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}