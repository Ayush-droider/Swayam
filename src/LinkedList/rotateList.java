package LinkedList;

import java.util.Scanner;

public class rotateList {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        Node temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % len;
        int stepsToNewHead = len - k;
        Node newTail = temp;
        while (stepsToNewHead-- > 0) newTail = newTail.next;
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rotateList list = new rotateList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) list.insertAtEnd(sc.nextInt());

        System.out.print("Enter k (number of rotations): ");
        int k = sc.nextInt();

        System.out.println("Original List:");
        list.display(list.head);

        list.head = list.rotateRight(list.head, k);

        System.out.println("Rotated List:");
        list.display(list.head);
    }
}
