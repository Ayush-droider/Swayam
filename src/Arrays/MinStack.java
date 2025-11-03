package Arrays;

import java.util.*;

public class MinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = mainStack.pop();
        if (val == minStack.peek()) minStack.pop();
        return val;
    }

    public int top() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();

        st.push(5);
        st.push(3);
        st.push(7);
        st.push(2);
        st.push(8);

        System.out.println("Top element: " + st.top());
        System.out.println("Minimum element: " + st.getMin());

        st.pop();
        st.pop();

        System.out.println("After popping two elements:");
        System.out.println("Top element: " + st.top());
        System.out.println("Minimum element: " + st.getMin());
    }
}
