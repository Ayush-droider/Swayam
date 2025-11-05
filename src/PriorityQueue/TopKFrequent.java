package PriorityQueue;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            minHeap.add(new int[]{e.getKey(), e.getValue()});
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) res[i] = minHeap.poll()[0];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for (int x : res) System.out.print(x + " ");
    }
}
