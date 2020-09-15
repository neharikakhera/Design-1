//Time complexity: O(1)
//SpaceComplexity: O(n): size of the stack
class MinStack {
    int min;
    // we maintain the a stack of arrays, whose first index is the element, and 2nd index is the minimum element found so far
    // this technique enables us to getMin() in O(1) time
    Stack<int[]> stack = new Stack<int[]>();
  //ask interviewer can I intialise min with amy maximum value: like Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
      
    }
    
    public void push(int x) {
        //while adding elements to the stack, we always keep track of minimum element and insert                    accordingly
        if(stack.isEmpty()){
            stack.push(new int[]{x, x});
            return;
        }
        int currMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currMin)});        
    }
    
    public void pop() {
       stack.pop();
    }
    
    public int top() {
        int arr[] = stack.peek();
        return arr[0];
    }
    
    public int getMin() {
        int[] arr = stack.peek();
        return arr[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */