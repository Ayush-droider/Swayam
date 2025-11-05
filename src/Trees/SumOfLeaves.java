package Trees;

public class SumOfLeaves {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int sumOfLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.data;
        return sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        System.out.println(sumOfLeaves(root));
    }
}
