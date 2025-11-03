package LinkedList;

import java.util.Scanner;

public class removeDuplicates {

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

    public void removeDuplicatesSorted() {
        if (head == null) return;
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) temp.next = temp.next.next;
            else temp = temp.next;
        }
    }

    public void display() {
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
        removeDuplicates list = new removeDuplicates();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) list.insertAtEnd(sc.nextInt());

        System.out.println("Original List:");
        list.display();

        list.removeDuplicatesSorted();

        System.out.println("After Removing Duplicates:");
        list.display();
    }
}
