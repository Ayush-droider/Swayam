package LinkedList;

import java.util.Scanner;

public class mergeTwoSortedLists {

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

    public static Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Node dummy = new Node(0);
        Node tail = dummy;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }

        if (h1 != null) tail.next = h1;
        if (h2 != null) tail.next = h2;

        return dummy.next;
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mergeTwoSortedLists list1 = new mergeTwoSortedLists();
        mergeTwoSortedLists list2 = new mergeTwoSortedLists();

        System.out.print("Enter number of elements in first sorted list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n1; i++) list1.insertAtEnd(sc.nextInt());

        System.out.print("Enter number of elements in second sorted list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n2; i++) list2.insertAtEnd(sc.nextInt());

        System.out.println("First ");
        list1.display(list1.head);
        System.out.println("Second ");
        list2.display(list2.head);

        Node mergedHead = merge(list1.head, list2.head);
        System.out.println("Merged Sorted ");
        list1.display(mergedHead);
    }
}
