package PriorityQueue;

import java.util.*;

public class MyPQ {
    List<Integer> heap = new ArrayList<>();

    void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(p) <= heap.get(i)) break;
            Collections.swap(heap, p, i);
            i = p;
        }
    }

    int peek() {
        return heap.isEmpty() ? -1 : heap.get(0);
    }

    int remove() {
        if (heap.isEmpty()) return -1;
        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }
        return root;
    }

    void heapify(int i) {
        int smallest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < heap.size() && heap.get(l) < heap.get(smallest)) smallest = l;
        if (r < heap.size() && heap.get(r) < heap.get(smallest)) smallest = r;
        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            heapify(smallest);
        }
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyPQ pq = new MyPQ();
        pq.add(10);
        pq.add(5);
        pq.add(20);
        pq.add(2);
        System.out.println("Top: " + pq.peek());
        System.out.println("Removed: " + pq.remove());
        System.out.println("Top after removal: " + pq.peek());
    }
}

