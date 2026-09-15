class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                         .boxed()
                         .collect(Collectors.toSet());
        if (set.size() !=  nums.length) {
            return true;
        }
        return false;
    }
}