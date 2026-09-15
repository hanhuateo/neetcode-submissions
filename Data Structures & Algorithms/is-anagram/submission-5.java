class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[128];
        int[] b = new int[128];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)] += 1;
        }

        for (int j = 0; j < t.length(); j++) {
            b[t.charAt(j)] += 1;
        }

        for (int k = 0; k < a.length; k++) {
            if (a[k] != b[k]) {
                return false;
            }
        }

        return true;
    }
}
