class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int right = n - 1;
        int left = 0;
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                break;
            } else if ((numbers[left] + numbers[right]) < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left+1, right+1};
    }
}
