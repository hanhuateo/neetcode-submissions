class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (!stack.isEmpty()) {
                    Integer int2 = stack.pop();
                    Integer int1 = stack.pop();
                    Integer result = 0;
                    switch (tokens[i]) {
                        case "+":
                            result = int1 + int2;
                            break;
                        case "-":
                            result = int1 - int2;
                            break;
                        case "*":
                            result = int1 * int2;
                            break;
                        case "/":
                            result = int1 / int2;
                            break;
                    }
                    stack.push(result);
                }
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
