class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < strs[0].length() && j < strs[n-1].length() && strs[0].charAt(i) == strs[n - 1].charAt(j)) {
            sb.append(strs[0].charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }
}