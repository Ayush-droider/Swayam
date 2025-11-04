package Trees;

import java.util.*;

public class BSTree {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    Node root;

    // Insert a new value in BST
    public Node insert(Node node, int val) {
        if (node == null) return new Node(val);

        if (val < node.data)
            node.left = insert(node.left, val);
        else if (val > node.data)
            node.right = insert(node.right, val);

        return node;
    }

    // Search for a value in BST
    public boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Find minimum value in BST
    public int minValue(Node node) {
        while (node.left != null)
            node = node.left;
        return node.data;
    }

    // Find maximum value in BST
    public int maxValue(Node node) {
        while (node.right != null)
            node = node.right;
        return node.data;
    }

    // Delete a node from BST
    public Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            // Node found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            int minVal = minValue(node.right);
            node.data = minVal;
            node.right = delete(node.right, minVal);
        }
        return node;
    }

    // Traversals
    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTree tree = new BSTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);

        System.out.print("\nEnter value to search: ");
        int key = sc.nextInt();
        System.out.println("Found: " + tree.search(tree.root, key));

        System.out.println("Min value: " + tree.minValue(tree.root));
        System.out.println("Max value: " + tree.maxValue(tree.root));

        System.out.print("Enter value to delete: ");
        int del = sc.nextInt();
        tree.root = tree.delete(tree.root, del);

        System.out.println("\nInorder after deletion:");
        tree.inorder(tree.root);
    }
}
