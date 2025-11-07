package Graphs;

import java.util.*;

public class ConnectedComponents {
    public void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int it : adj.get(node)) {
            if (!visited[it]) dfs(it, visited, adj);
        }
    }

    public void findConnectedComponents(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Component " + count + ": ");
                dfs(i, visited, adj);
                System.out.println();
            }
        }
        System.out.println("Total Connected Components: " + count);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(4).add(5);
        adj.get(5).add(4);

        ConnectedComponents obj = new ConnectedComponents();
        obj.findConnectedComponents(V, adj);
    }
}
