class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        while (left < right && left != right) {
            int height = heights[left] <= heights[right] ? heights[left] : heights[right];
            int width = right - left;
            maxArea = Math.max(maxArea, width * height);
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
