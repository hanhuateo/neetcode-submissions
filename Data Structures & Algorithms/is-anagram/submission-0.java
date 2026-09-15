class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) != null) {
                int count = map.get(c);
                count = count + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map2.get(c) != null) {
                int count = map2.get(c);
                count = count + 1;
                map2.put(c, count);
            } else {
                map2.put(c, 1);
            }
        }
        System.out.println(map);
        System.out.println(map2);
        return map.equals(map2);
    }
}
