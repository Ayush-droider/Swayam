package Trees;

import java.util.*;

public class BottomView {
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

    public static void bottomView(Node root) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            map.put(curr.hd, curr.node.data);
            if (curr.node.left != null) q.add(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) q.add(new Pair(curr.node.right, curr.hd + 1));
        }
        for (int val : map.values()) System.out.print(val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        bottomView(root);
    }
}

