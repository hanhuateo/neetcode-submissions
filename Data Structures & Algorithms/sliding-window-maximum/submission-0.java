class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && nums[right] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(right);

            int windowSize = right - left + 1;
            if (windowSize == k) {
                result[left] = nums[deque.getFirst()];
                left++;
            }

            if (left > deque.getFirst()) {
                deque.removeFirst();
            }
        }
        return result;
    }
}
