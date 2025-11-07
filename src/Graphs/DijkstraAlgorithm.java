package Graphs;

import java.util.*;

public class DijkstraAlgorithm {
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int d = cur.weight;
            if (d > dist[u]) continue;

            for (Pair it : adj.get(u)) {
                int v = it.node;
                int wt = it.weight;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 4));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 2));
        adj.get(1).add(new Pair(3, 5));
        adj.get(2).add(new Pair(3, 5));
        adj.get(2).add(new Pair(4, 9));
        adj.get(3).add(new Pair(4, 4));

        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int[] dist = obj.dijkstra(V, adj, 0);

        System.out.println("Shortest distances from source (0):");
        for (int d : dist) System.out.print(d + " ");
    }
}
