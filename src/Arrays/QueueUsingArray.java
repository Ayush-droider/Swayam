package Arrays;

import java.util.*;

public class QueueUsingArray {

    int front, rear, size;
    int[] queue;

    QueueUsingArray(int capacity) {
        queue = new int[capacity];
        size = capacity;
        front = rear = -1;
    }

    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = data;
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return queue[front++];
    }

    public int peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        System.out.println("Dequeued element: " + q.dequeue());
        q.display();

        System.out.println("Front element: " + q.peek());
        System.out.println("Is queue empty: " + q.isEmpty());
    }
}
