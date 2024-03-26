package algorithms.w3schools;

import java.util.LinkedList;

public class LinkedListDemo {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Creating individual nodes
        Node firstNode = new Node(3);
        Node secondNode = new Node(5);
        Node thirdNode = new Node(13);
        Node fourthNode = new Node(2);

        // Linking nodes together
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        // Printing linked list
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");


    // Using LinkedList
    // Create a LinkedList
    LinkedList<String> linkedList = new LinkedList<>();

    // Adding elements to the LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        linkedList.add("Grapes");

    // Displaying the elements of the LinkedList
        System.out.println("LinkedList: " + linkedList);

    // Adding an element at the beginning of the LinkedList
        linkedList.addFirst("Strawberry");
        System.out.println("LinkedList after adding Strawberry at first: " + linkedList);

    // Adding an element at the end of the LinkedList
        linkedList.addLast("Mango");
        System.out.println("LinkedList after adding Mango at last: " + linkedList);

    // Getting the first element of the LinkedList
    String firstElement = linkedList.getFirst();
        System.out.println("First element of LinkedList: " + firstElement);

    // Getting the last element of the LinkedList
    String lastElement = linkedList.getLast();
        System.out.println("Last element of LinkedList: " + lastElement);

    // Removing the first element from the LinkedList
        linkedList.removeFirst();
        System.out.println("LinkedList after removing the first element: " + linkedList);

    // Removing the last element from the LinkedList
        linkedList.removeLast();
        System.out.println("LinkedList after removing the last element: " + linkedList);

    // Checking if the LinkedList contains a specific element
    String searchElement = "Orange";
        if (linkedList.contains(searchElement)) {
        System.out.println("LinkedList contains " + searchElement);
    } else {
        System.out.println("LinkedList does not contain " + searchElement);
    }

    // Getting the size of the LinkedList
    int size = linkedList.size();
        System.out.println("Size of LinkedList: " + size);

    // Clearing the LinkedList
        linkedList.clear();
        System.out.println("LinkedList after clearing: " + linkedList);
}
}
