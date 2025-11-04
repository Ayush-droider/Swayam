package Trees;

import java.util.*;

public class DiaTree {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    Node root;

    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left == null) {
                curr.left = newNode;
                break;
            } else q.add(curr.left);

            if (curr.right == null) {
                curr.right = newNode;
                break;
            } else q.add(curr.right);
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int diameter(Node node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        int leftD = diameter(node.left);
        int rightD = diameter(node.right);
        return Math.max(leftH + rightH, Math.max(leftD, rightD));
    }

    static class Info {
        int height, diameter;
        Info(int h, int d) {
            height = h;
            diameter = d;
        }
    }

    public Info diameterFast(Node node) {
        if (node == null) return new Info(0, 0);

        Info left = diameterFast(node.left);
        Info right = diameterFast(node.right);

        int myHeight = 1 + Math.max(left.height, right.height);
        int myDiameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

        return new Info(myHeight, myDiameter);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DiaTree tree = new DiaTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++)
            tree.insert(sc.nextInt());

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nHeight: " + tree.height(tree.root));
        System.out.println("Diameter (O(n²)): " + tree.diameter(tree.root));
        System.out.println("Diameter (O(n) fast): " + tree.diameterFast(tree.root).diameter);
    }
}
