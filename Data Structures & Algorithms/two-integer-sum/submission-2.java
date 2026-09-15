class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums[i] to i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int difference;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i];
            if (map.containsKey(difference) && i != map.get(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                break;
            }
        }
        return result;
    }
}
