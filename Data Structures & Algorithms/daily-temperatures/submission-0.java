class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) {
            return new int[0];
        }
        int[] result = new int[n];
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(new Pair<>(temp, i));
                continue;
            }
            // while stack is empty and current temperature is more than the temperature at the top of the stack
            while (!stack.isEmpty() && temp > stack.peek().getKey().intValue()) {
                int index = stack.pop().getValue().intValue();
                result[index] = i - index;
            }
            stack.push(new Pair<>(temp, i));
        }
        return result;
    }
}
