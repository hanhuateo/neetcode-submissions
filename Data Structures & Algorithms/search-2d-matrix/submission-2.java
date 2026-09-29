class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int innerLength = matrix[i].length;
            int left = 0;
            int right = innerLength - 1;
            while (left < right) {
                int midIndex = (left + right) / 2;
                int midNum = matrix[i][midIndex];
                if (midNum == target) {
                    return true;
                }

                if (midNum < target) {
                    left = midIndex + 1;
                }

                if (midNum > target) {
                    right = midIndex - 1;
                }
            }

            if (left == right && matrix[i][left] == target) {
                return true;
            }
        }
        return false;
    }
}
