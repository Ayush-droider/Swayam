package Arrays;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data) {
        while (!s1.isEmpty()) s2.push(s1.pop());
        s1.push(data);
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public void display() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = s1.size() - 1; i >= 0; i--) System.out.print(s1.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
