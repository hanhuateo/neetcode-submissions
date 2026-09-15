class MinStack {
    private int min;
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (val <= this.min) {
            this.min = val;
            this.minStack.push(this.min);
        }
        this.stack.push(val);
    }
    
    public void pop() {
        if (this.stack.peek().equals(this.min) && this.minStack.peek().equals(this.min)) {
            this.minStack.pop();
            if (this.minStack.isEmpty()) {
                this.min = Integer.MAX_VALUE;
            } else {
                this.min = this.minStack.peek();
            }
        }
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
