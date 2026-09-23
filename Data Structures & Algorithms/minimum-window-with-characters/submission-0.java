class Solution {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < tLength) {
            return "";
        }

        int[] tCount = new int[128];
        for (int i = 0; i < tLength; i++) {
            tCount[t.charAt(i)]++;
        }

        int numberOfDistinctLettersInT = 0;
        for (int count : tCount) {
            if (count > 0) {
                numberOfDistinctLettersInT++;
            }
        }

        int[] windowCount = new int[128];
        int numberOfMatches = 0;
        int left = 0;
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        for (int right = 0; right < sLength; right++) {
            // computing per character in each position of string s.
            char c = s.charAt(right);
            windowCount[c]++;
            if (tCount[c] > 0 && tCount[c] == windowCount[c]) {
                numberOfMatches++;
            }

            // we will check if there is a need to move the left pointer
            while (numberOfMatches == numberOfDistinctLettersInT) {
                int windowSize = right - left + 1;
                // log the substring that satisfies the condition
                if (windowSize < resLen) {
                    resLen = windowSize;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                windowCount[leftChar]--;
                if (tCount[leftChar] > 0 && windowCount[leftChar] < tCount[leftChar]) {
                    numberOfMatches--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
