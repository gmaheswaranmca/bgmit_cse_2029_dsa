class MyQueue {
    private Stack<Integer> inStk;
    private Stack<Integer> outStk;
    public MyQueue() {
        inStk = new Stack<>();
        outStk = new Stack<>();
    }
    
    public void push(int x) {
        inStk.add(x);
    }
    
    public int pop() {
        if(outStk.size() == 0) {
            while(inStk.size() > 0) {
                outStk.add(inStk.pop());
            }
        }
        return outStk.pop();
    }
    
    public int peek() {
        if(outStk.size() == 0) {
            while(inStk.size() > 0) {
                outStk.add(inStk.pop());
            }
        }
        return outStk.peek();
    }
    
    public boolean empty() {
        return inStk.size() == 0 && outStk.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */