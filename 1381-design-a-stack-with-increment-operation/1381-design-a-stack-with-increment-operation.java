class CustomStack {

    private int[] stack;
    private int maxSize;
    private int index;
    
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
        index = 0;
    }
    
    public void push(int x) {
        if (index >= maxSize) {
            return;
        }
        stack[index++] = x;
    }
    
    public int pop() {
        if (index == 0) {
            return -1;
        }
        return stack[--index];
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(maxSize, k);
        
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */