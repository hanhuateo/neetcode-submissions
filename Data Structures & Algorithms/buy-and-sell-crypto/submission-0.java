class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        for (int left = 0; left < n; left++) {
            int right = left + 1;
            while (right < n) {
                result = Math.max(result, prices[right] - prices[left]);
                right++;
            }
        }
        return result;
    }
}
