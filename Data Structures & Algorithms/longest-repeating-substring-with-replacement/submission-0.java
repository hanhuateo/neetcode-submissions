class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            count.put(s.charAt(right), count.computeIfAbsent(s.charAt(right), j -> 0) + 1);
            int windowSize = right - left + 1;
            int highestCount = this.getHighestCount(count);
            while (windowSize - highestCount > k) {
                count.put(s.charAt(left), count.computeIfAbsent(s.charAt(left), j -> 0) - 1);
                left++;
                windowSize = right - left + 1;
                highestCount = this.getHighestCount(count);
            }
            result = Math.max(result, windowSize);
        }
        return result;
    }

    public int getHighestCount(Map<Character, Integer> count) {
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getValue().intValue();
    }
}
