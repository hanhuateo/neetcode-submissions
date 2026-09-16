class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right && left != right) {
                int intermediate = nums[i] + nums[left] + nums[right];
                if (intermediate > 0) {
                    right--;
                } else if (intermediate < 0) {
                    left++;
                } else {
                    if (!result.contains(List.of(nums[i], nums[left], nums[right]))) {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
