package Graphs;

import java.util.*;

public class PrimsAlgorithm {
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int primsMST(int V, List<List<Pair>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(0, 0));
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            if (visited[u]) continue;
            visited[u] = true;
            totalWeight += cur.weight;

            for (Pair it : adj.get(u)) {
                if (!visited[it.node]) pq.add(new Pair(it.node, it.weight));
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));
        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));
        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));
        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));
        adj.get(2).add(new Pair(4, 7));
        adj.get(4).add(new Pair(2, 7));

        PrimsAlgorithm obj = new PrimsAlgorithm();
        System.out.println(obj.primsMST(V, adj)); // Output: 16
    }
}
