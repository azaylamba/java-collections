package main;

public class SimpleLinkedList {
    Node head;

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insertNode(int data) {
        Node node = new Node(data);
        //if list is empty add to head
        if(this.head == null) {
            this.head = node;
        } else {
            Node last = this.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
    }

    public void printList() {
        Node currNode = this.head;
        System.out.print("Simple Linked list: ");

        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public void deleteByKey(int key) {
        if(this.head == null) {
            System.out.println("List is empty, could not delete");
        }

        //Case 1: Key is head of list
        if(this.head.data == key) {
            System.out.println(key + " deleted from list");
            this.head = this.head.next;
            return;
        }
        //Case 2: key is in middle of list
        Node currNode = this.head;
        Node prevNode = null;
        while (currNode != null && currNode.data != key) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(currNode != null) {
            prevNode.next = currNode.next;
            System.out.println(key + " deleted key from list");
            return;
        }
        //Case 3: If key is not present
        if(currNode == null) {
            System.out.println("Key not present in list");
        }
    }
}
