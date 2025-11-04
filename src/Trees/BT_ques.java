package Trees;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BT_ques {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else q.add(temp.left);

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else q.add(temp.right);
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        return 1 + Math.max(leftH, rightH);
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.data != q.data) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.data == b.data)
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BT_ques tree1 = new BT_ques();
        BT_ques tree2 = new BT_ques();

        System.out.print("Enter number of nodes for Tree 1: ");
        int n = sc.nextInt();
        System.out.println("Enter node values for Tree 1:");
        for (int i = 0; i < n; i++)
            tree1.insert(sc.nextInt());

        System.out.print("Enter number of nodes for Tree 2: ");
        int m = sc.nextInt();
        System.out.println("Enter node values for Tree 2:");
        for (int i = 0; i < m; i++)
            tree2.insert(sc.nextInt());

        System.out.println("\nInorder traversal of Tree 1:");
        tree1.inorder(tree1.root);

        System.out.println("\n\nHeight of Tree 1: " + tree1.height(tree1.root));
        System.out.println("Trees are same: " + tree1.isSameTree(tree1.root, tree2.root));
        System.out.println("Tree 1 is symmetric: " + tree1.isSymmetric(tree1.root));
    }
}
