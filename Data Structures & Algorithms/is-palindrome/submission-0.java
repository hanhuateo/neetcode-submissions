class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s1.length();
        int mid = n / 2;
        boolean res;
        if (n % 2 == 0) {
            res = intermediate(s1, mid - 1, mid);
        } else {
            res = intermediate(s1, mid, mid);
        }
        return res;
    }

    public boolean intermediate(String s, int index1, int index2) {
        System.out.println("s: " + s);
        while (index1 >= 0 && index2 < s.length()) {
            if (s.charAt(index1) == s.charAt(index2)) {
                index1--;
                index2++;
            } else {
                return false;
            }
        }
        return true;
    }
}
