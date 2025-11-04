package Trees;

import java.util.*;

public class PathSumTree {

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

    public boolean hasPathSum(Node node, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null)
            return targetSum == node.data;

        return hasPathSum(node.left, targetSum - node.data) ||
                hasPathSum(node.right, targetSum - node.data);
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PathSumTree tree = new PathSumTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++)
            tree.insert(sc.nextInt());

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        boolean result = tree.hasPathSum(tree.root, target);
        System.out.println("\nPath sum exists: " + result);
    }
}
