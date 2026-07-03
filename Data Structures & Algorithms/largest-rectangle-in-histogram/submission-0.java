class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            int j = i;
            int k = i;

            // expand left
            while (j >= 0 && heights[j] >= height) {
                j--;
            }

            // expand right
            while (k < heights.length && heights[k] >= height) {
                k++;
            }

            int width = k - j - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}