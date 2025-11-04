package Trees;

import java.util.*;

public class ViewTree {

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

    public List<Integer> leftView(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == 0) res.add(curr.data);  // first node of each level
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return res;
    }

    public List<Integer> rightView(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i == size - 1) res.add(curr.data);  // last node of each level
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return res;
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ViewTree tree = new ViewTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++)
            tree.insert(sc.nextInt());

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nLeft View: " + tree.leftView(tree.root));
        System.out.println("Right View: " + tree.rightView(tree.root));
    }
}
