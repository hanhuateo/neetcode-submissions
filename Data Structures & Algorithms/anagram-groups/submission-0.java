class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String string = strs[i];
            int[] a = new int[128];
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                a[c] += 1;
            }
            int[] subarray = Arrays.copyOfRange(a, 97, 123);
            List<Integer> list = Arrays.stream(subarray)
                              .boxed()
                              .toList();
            map.computeIfAbsent(list, k -> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
