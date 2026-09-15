class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if ((peek.equals('(') && c.equals(')')) || 
                        (peek.equals('[') && c.equals(']')) || 
                        (peek.equals('{') && c.equals('}'))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}
