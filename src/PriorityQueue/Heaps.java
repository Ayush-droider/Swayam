package PriorityQueue;

import java.util.*;

class MinHeap {
    List<Integer> heap = new ArrayList<>();

    void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(p) <= heap.get(i)) break;
            Collections.swap(heap, i, p);
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
        int smallest = i, l = 2 * i + 1, r = 2 * i + 2;
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
}

class MaxHeap {
    List<Integer> heap = new ArrayList<>();

    void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(p) >= heap.get(i)) break;
            Collections.swap(heap, i, p);
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
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < heap.size() && heap.get(l) > heap.get(largest)) largest = l;
        if (r < heap.size() && heap.get(r) > heap.get(largest)) largest = r;
        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapify(largest);
        }
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }
}

public class Heaps {
    public static void main(String[] args) {
        MinHeap min = new MinHeap();
        MaxHeap max = new MaxHeap();

        int[] nums = {10, 4, 15, 20, 0, 8};

        for (int n : nums) {
            min.add(n);
            max.add(n);
        }

        System.out.println("Min-Heap Peek: " + min.peek());
        System.out.println("Max-Heap Peek: " + max.peek());
        System.out.println("Remove from MinHeap: " + min.remove());
        System.out.println("Remove from MaxHeap: " + max.remove());
        System.out.println("Min-Heap Peek after removal: " + min.peek());
        System.out.println("Max-Heap Peek after removal: " + max.peek());
    }
}
