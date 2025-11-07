package Graphs;

import java.util.*;

public class HasPath {
    public boolean hasPath(int V, List<List<Integer>> adj, int src, int dest) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) return true;
            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.offer(it);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(0, 3));
        adj.get(2).add(4);
        adj.get(3).add(5);
        adj.get(4).add(5);

        HasPath obj = new HasPath();
        System.out.println(obj.hasPath(V, adj, 0, 5)); // Output: true
    }
}

