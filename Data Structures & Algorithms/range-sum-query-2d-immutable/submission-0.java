class NumMatrix {
    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sumMat = new int[m+1][n+1];
        for(int i=0;i<m;i++) {
            int prefix = 0;
            for(int j=0;j<n;j++) {
                prefix += matrix[i][j];
                int above = sumMat[i][j+1];
                sumMat[i+1][j+1] = prefix+above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1-1][col2];
        int topLeft = sumMat[row1-1][col1-1];
        int left = sumMat[row2][col1-1];
        return bottomRight-above + topLeft - left;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */