class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // position, speed
        List<Pair<Integer, Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair<>(position[i], speed[i]));
        }
        // sort arr in descending order based on position
        arr.sort((a,b) -> b.getKey() - a.getKey());
        Deque<Double> stack = new ArrayDeque<>();
        for (Pair<Integer, Integer> pair : arr) {
            int distance = target - pair.getKey();
            double timeTaken = (double) distance / pair.getValue();
            if (stack.isEmpty()) {
                stack.push(timeTaken);
            } else {
                if (timeTaken > stack.peek()) {
                    stack.push(timeTaken);
                }
            }
        }
        return stack.size();
    }
}
