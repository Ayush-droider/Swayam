package Graphs;

import java.util.*;

public class BFS {
    public void bfsTraversal(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.offer(it);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).add(3);
        adj.get(2).add(4);

        BFS obj = new BFS();
        System.out.print("BFS Traversal: ");
        obj.bfsTraversal(V, adj);
    }
}

