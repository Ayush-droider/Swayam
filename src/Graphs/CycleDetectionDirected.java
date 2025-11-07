package Graphs;

import java.util.*;

public class CycleDetectionDirected {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVis)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVis) {
        visited[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                if (dfs(it, adj, visited, pathVis)) return true;
            } else if (pathVis[it]) return true;
        }

        pathVis[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // cycle

        CycleDetectionDirected obj = new CycleDetectionDirected();
        System.out.println(obj.isCyclic(V, adj)); // Output: true
    }
}
