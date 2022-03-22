package com.datastructure.linkedlist.circular;

public class CircularLinkedList {

  Node head;

  static void getJosephusPosition(int m, int n) {
    // Create a circular linked list of
    // size N.
    Node head = new Node(1);
    Node prev = head;
    for (int i = 2; i <= n; i++) {
      prev.next = new Node(i);
      prev = prev.next;
    }

    // Connect last node to first
    prev.next = head;

        /* while only one node is left in the
        linked list*/
    Node ptr1 = head, ptr2 = head;

    while (ptr1.next != ptr1) {

      // Find m-th node
      int count = 1;
      while (count != m) {
        ptr2 = ptr1;
        ptr1 = ptr1.next;
        count++;
      }

      /* Remove the m-th node */
      ptr2.next = ptr1.next;
      ptr1 = ptr1.next;
    }
    System.out.println("Last person left standing " +
        "(Josephus Position) is " + ptr1.data);
  }

  public static void main(String[] args) {
    CircularLinkedList circularLinkedList = new CircularLinkedList();
    circularLinkedList.push(2);
    circularLinkedList.push(5);
    circularLinkedList.push(7);
    circularLinkedList.push(8);
    circularLinkedList.push(10);
    circularLinkedList.delete(7);
    circularLinkedList.delete(10);
    circularLinkedList.printList(circularLinkedList.head);

    int n = 14, m = 3;
    CircularLinkedList.getJosephusPosition(m, n);
  }

  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    if (head == null) {
      newNode.next = newNode;
    } else {
      Node temp = head;
      while (temp.next != head) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    head = newNode;
  }

  public void printList(Node head) {
    Node temp = head;
    if (head != null) {
      do {
        System.out.printf("%d ", temp.data);
        temp = temp.next;
      } while (temp != head);
    }
    System.out.println();
  }

  public void delete(int keyToDelete) {
    if (head == null) {
      return;
    }
    Node current = head;
    Node prev = null;
    while (current.data != keyToDelete) {
      if (current.next == head) {
        System.out.println("Key not present in list");
        return;
      }
      prev = current;
      current = current.next;
    }

    if (head.next == head) {
      head = null;
      return;
    }

    if (current == head) {
      prev = head;
      while (prev.next != head) {
        prev = prev.next;
      }
      head = current.next;
    }
    prev.next = current.next;
  }

  static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }
}
