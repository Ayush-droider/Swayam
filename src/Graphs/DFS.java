package Graphs;

import java.util.*;

public class DFS {
    public void dfsTraversal(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal: ");
        dfs(0, visited, adj);
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int it : adj.get(node)) {
            if (!visited[it]) dfs(it, visited, adj);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).add(3);
        adj.get(2).add(4);

        DFS obj = new DFS();
        obj.dfsTraversal(V, adj);
    }
}
