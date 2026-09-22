class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int s1length = s1.length();
        int s2length = s2.length();
        if (s1length > s2length) {
            return false;
        }

        int[] s1count = new int[128];
        int[] s2count = new int[128];
        for (int i = 0; i < s1length; i++) {
            s1count[s1.charAt(i)] += 1;
            s2count[s2.charAt(i)] += 1;
        }

        int left = 0;
        for (int right = s1length; right < s2length; right++) {
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }

            s2count[s2.charAt(left)] -= 1;
            left++;
            s2count[s2.charAt(right)] += 1;
        }

        return Arrays.equals(s1count, s2count);

    }
}
