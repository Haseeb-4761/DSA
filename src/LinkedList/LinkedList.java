package LinkedList;

public class LinkedList {
    // Node class representing each element in the linked list
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor to initialize the LinkedList
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to append a value to the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            // If the list is empty, the new node becomes both the head and tail
            head = tail = newNode;
        } else {
            // Append to the end and update the tail pointer
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to print the elements of the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        linkedList.printList();  // Output: 1 -> 2 -> 3 -> None
    }
}
