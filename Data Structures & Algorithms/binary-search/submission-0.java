class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midIndex = (left + right) / 2;
            int midNum = nums[midIndex];
            if (midNum == target) {
                return midIndex;
            } else {
                if (midNum < target) {
                    left = midIndex + 1;
                }
                if (midNum > target) {
                    right = midIndex - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
