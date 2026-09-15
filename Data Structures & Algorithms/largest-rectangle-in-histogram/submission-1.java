class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        // pair (index, height)
        Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            if (stack.isEmpty()) {
                stack.push(new Pair<>(i, height));
            } else {
                int prevHeight = stack.peek().getValue().intValue();
                int prevIndex = stack.peek().getKey().intValue();
                if (prevHeight <= height) {
                    stack.push(new Pair<>(i, height));
                } else {
                    while (stack.peek() != null && stack.peek().getValue().intValue() > height) {
                        prevHeight = stack.peek().getValue().intValue();
                        prevIndex = stack.peek().getKey().intValue();
                        int width = i - prevIndex;
                        maxArea = Math.max(maxArea, prevHeight * width);
                        stack.pop();
                    }
                    stack.push(new Pair<>(prevIndex, height));
                }
            }
        }
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> top = stack.pop();
            int index = top.getKey().intValue();
            int height = top.getValue().intValue();
            int width = n - index;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
