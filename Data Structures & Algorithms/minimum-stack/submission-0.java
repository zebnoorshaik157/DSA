class MinStack {
    Stack<Integer>st;
    Stack<Integer>minst;
    public MinStack() {
         st=new Stack<>();
         minst=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || val <=minst.peek()) {
            minst.push(val);
        }

    }
    
    public void pop() {
        int val=st.pop();
        if(val==minst.peek()) {
            minst.pop();
        }
    }
    
    public int top() {
       return  st.peek();
    }
    
    public int getMin() {
      return   minst.peek();
    }
}
