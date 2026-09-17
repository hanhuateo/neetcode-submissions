class Solution {
    public int trap(int[] height) {
        // O(n) space complexity
        // O(n) time complexity
        int n = height.length;

        int[] maxLeftArr = new int[n];
        int[] maxRightArr = new int[n];

        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < n; i++) {
            maxLeftArr[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            maxRightArr[i] = maxRight;
            maxRight = Math.max(maxRight, height[i]);
        }

        int[] minLeftRightArr = new int[n];
        for (int i = 0; i < n; i++) {
            minLeftRightArr[i] = Math.min(maxLeftArr[i], maxRightArr[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int intermediate = minLeftRightArr[i] - height[i];
            if (intermediate > 0) {
                result += intermediate;
            }
        }

        return result;
    }
}
