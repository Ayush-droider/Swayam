package Arrays;

import java.util.Scanner;

public class StackUsingArrays {

    int top;
    int[] stack;
    int size;

    StackUsingArrays(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) System.out.print(stack[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingArrays st = new StackUsingArrays(5);

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.display();

        System.out.println("Popped element: " + st.pop());
        st.display();

        System.out.println("Top element: " + st.peek());
        System.out.println("Is stack empty: " + st.isEmpty());
    }
}
