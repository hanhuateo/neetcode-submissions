class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int zero_count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                prod *= nums[i];
            } else {
                zero_count++;
            }
        }
        int[] result = new int[n];
        if (zero_count > 1) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            if (zero_count == 1) {
                if (nums[i] == 0) {
                    result[i] = prod;
                } else {
                    result[i] = 0;
                }
            }

            if (zero_count == 0) {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }
}  
