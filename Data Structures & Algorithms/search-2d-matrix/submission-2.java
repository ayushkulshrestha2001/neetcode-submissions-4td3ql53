class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length -1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(target>matrix[mid][0]) {
                l = mid +1;
            } else {
                r = mid-1;
            }
        }
        if (r < 0) return false;
        int l1 = 0, r1 = matrix[0].length-1;
        while(l1<=r1) {
            int mid = l1+(r1 - l1)/2;
            if(matrix[r][mid]==target) {
                return true;
            } else if(target>matrix[r][mid]) {
                l1 = mid+1;
            } else {
                r1 = mid-1;
            }
        }
        return false;
    }
}
