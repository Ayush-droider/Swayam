package Graphs;

import java.util.*;

public class CycleDetectionUndirected {
    static class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int it : adj.get(p.node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(new Pair(it, p.node));
                } else if (it != p.parent) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1); // creates a cycle

        CycleDetectionUndirected obj = new CycleDetectionUndirected();
        System.out.println(obj.isCycle(V, adj)); // Output: true
    }
}

