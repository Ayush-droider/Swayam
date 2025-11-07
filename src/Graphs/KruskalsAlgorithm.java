package Graphs;

import java.util.*;

public class KruskalsAlgorithm {
    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent, rank;
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return;
            if (rank[pu] < rank[pv]) parent[pu] = pv;
            else if (rank[pv] < rank[pu]) parent[pv] = pu;
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }

    public int kruskalsMST(int V, List<Edge> edges) {
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
        DisjointSet ds = new DisjointSet(V);
        int totalWeight = 0;

        for (Edge e : edges) {
            if (ds.find(e.u) != ds.find(e.v)) {
                totalWeight += e.weight;
                ds.union(e.u, e.v);
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        KruskalsAlgorithm obj = new KruskalsAlgorithm();
        System.out.println(obj.kruskalsMST(V, edges)); // Output: 16
    }
}

