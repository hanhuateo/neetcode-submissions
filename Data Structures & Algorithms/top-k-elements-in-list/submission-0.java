class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // number to frequency
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // swap the position of number and frequency
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // value is frequency
            // key is number
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        // sorting based on the frequency, in ascending order
        arr.sort((a,b) -> b[0] - a[0]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr.get(i)[1];
        }
        return result;
    }
}
