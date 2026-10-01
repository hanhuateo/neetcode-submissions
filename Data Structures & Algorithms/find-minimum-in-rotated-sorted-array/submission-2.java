class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = 1001;
        while (left < right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            min = Math.min(min, midNum);

            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                right = mid - 1;
            } else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            }
        }
        System.out.println("left : " + left);
        System.out.println("right : " + right);
        min = Math.min(min, nums[left]);
        return min;
    }
}
