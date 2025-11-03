package LinkedList;

import java.util.Scanner;

public class addTwoNumbers {

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

    public static Node addNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addTwoNumbers list1 = new addTwoNumbers();
        addTwoNumbers list2 = new addTwoNumbers();

        System.out.print("Enter number of digits in first number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter digits (in reverse order):");
        for (int i = 0; i < n1; i++) list1.insertAtEnd(sc.nextInt());

        System.out.print("Enter number of digits in second number: ");
        int n2 = sc.nextInt();
        System.out.println("Enter digits (in reverse order):");
        for (int i = 0; i < n2; i++) list2.insertAtEnd(sc.nextInt());

        System.out.println("First number: ");
        list1.display(list1.head);
        System.out.println("Second number: ");
        list2.display(list2.head);

        Node sum = addNumbers(list1.head, list2.head);
        System.out.println("Sum: ");
        list1.display(sum);
    }
}
