package Trees;

import java.util.*;

public class CheckBST {

    static class Node {
        int data;
        Node left, right;
        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    Node root;

    public Node insert(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.data)
            node.left = insert(node.left, val);
        else if (val > node.data)
            node.right = insert(node.right, val);
        return node;
    }

    public boolean isValidBST(Node node) {
        return validate(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CheckBST tree = new CheckBST();
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++)
            tree.root = tree.insert(tree.root, sc.nextInt());
        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);
        System.out.println("\nValid BST: " + tree.isValidBST(tree.root));
    }
}
