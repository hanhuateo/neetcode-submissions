class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        System.out.println(set.toString());
        int res = 0;
        int diff = 1;
        int count = 1;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                // this is the start of a sequence
                while (diff < nums.length) {
                    if (set.contains(num + diff)) {
                        count++;
                        diff++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, count);
                count = 1;
                diff = 1;
            }
        }
        return res;
    }
}
