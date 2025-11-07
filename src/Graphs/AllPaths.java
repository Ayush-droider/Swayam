package Graphs;

import java.util.*;

public class AllPaths {
    public void printAllPaths(List<List<Integer>> adj, int src, int dest, boolean[] visited, List<Integer> path) {
        visited[src] = true;
        path.add(src);
        if (src == dest) {
            System.out.println(path);
        } else {
            for (int it : adj.get(src)) {
                if (!visited[it]) {
                    printAllPaths(adj, it, dest, visited, path);
                }
            }
        }
        path.remove(path.size() - 1);
        visited[src] = false;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2));
        adj.get(1).addAll(Arrays.asList(3));
        adj.get(2).addAll(Arrays.asList(3, 4));
        adj.get(3).addAll(Arrays.asList(5));
        adj.get(4).addAll(Arrays.asList(5));

        AllPaths obj = new AllPaths();
        System.out.println("All paths from 0 to 5:");
        obj.printAllPaths(adj, 0, 5, new boolean[V], new ArrayList<>());
    }
}
