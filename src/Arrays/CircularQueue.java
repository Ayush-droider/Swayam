package Arrays;

public class CircularQueue {

    int front, rear, size;
    int[] queue;

    CircularQueue(int capacity) {
        size = capacity;
        queue = new int[size];
        front = rear = -1;
    }

    public void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Overflow");
            return;
        }
        if (front == -1) front = 0;
        rear = (rear + 1) % size;
        queue[rear] = data;
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int data = queue[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % size;
        return data;
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        q.enqueue(50);
        q.enqueue(60);
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
