package Trees;

import java.util.*;

public class TopView {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!map.containsKey(curr.hd)) map.put(curr.hd, curr.node.data);
            if (curr.node.left != null) q.add(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) q.add(new Pair(curr.node.right, curr.hd + 1));
        }
        for (int val : map.values()) System.out.print(val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        topView(root);
    }
}
