class MinStack {
    Deque<Integer> stack;
    Deque<Integer> stackMinSeen;
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.stackMinSeen = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(stackMinSeen.isEmpty()){
            stackMinSeen.push(val);
        }else{
            stackMinSeen.push(Math.min(stackMinSeen.peek(), val));
        }
    }
    
    public void pop() {
        stack.pop();
        stackMinSeen.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stackMinSeen.peek();
    }
}
