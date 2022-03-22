package com.datastructure.linkedlist.doubly;

import com.sun.istack.internal.NotNull;

public class DoublyLinkedList {

  private DLLNode head;

  public static void main(String[] args) {
    int key;
    DoublyLinkedList list = new DoublyLinkedList();

    System.out.println("---------------------------");
    list.push(10);
    list.insertBefore(list.head, 5);
    list.insertAfter(list.head.next, 15);
    list.push(20);
    list.push(30);
    list.append(18);
    System.out.println("Sorted List Before Deletion");
    list.printList();
    key = 15;
    list.deleteNode(key);
    System.out.printf("List After Deletion of Key : %d%n", key);
    list.printList();
    list.deleteList();
    System.out.println("---------------------------");

    list.push(9);
    list.insertInSortedLL(5);
    list.insertInSortedLL(4);
    list.insertInSortedLL(6);
    list.insertInSortedLL(2);
    list.insertInSortedLL(1);
    System.out.println("Sorted List Before insertion");
    list.printList();
    key = 8;
    list.insertInSortedLL(key);
    System.out.printf("Sorted List After Insertion of Key : %d%n", key);
    list.printList();
    list.countTriplets(17);
    System.out.println("---------------------------");

  }

  public void push(int newData) {

    DLLNode node = new DLLNode(newData);
    node.prev = null;
    node.next = head;
    if (head != null) {
      head.prev = node;
    }
    head = node;
  }

  public void insertAfter(@NotNull DLLNode prevNode, int newData) {
    if (prevNode == null) {
      return;
    }
    DLLNode node = new DLLNode(newData);
    node.prev = prevNode;
    node.next = prevNode.next;
    prevNode.next = node;
    if (node.next != null) {
      node.next.prev = node;
    }
  }

  public void insertBefore(@NotNull DLLNode nextNode, int newData) {
    if (nextNode == null) {
      return;
    }
    DLLNode node = new DLLNode(newData);
    node.next = nextNode;
    node.prev = nextNode.prev;
    nextNode.prev = node;
    if (node.prev != null) {
      node.prev.next = node;
    } else {
      head = node;
    }
  }

  public void append(int newData) {
    DLLNode node = new DLLNode(newData);
    DLLNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    node.prev = current;
    node.next = null;
    current.next = node;
  }

  public void deleteNode(int data) {
    if (head == null) {
      return;
    }
    DLLNode nodeToDelete = head;
    while (nodeToDelete.data != data) {
      if (nodeToDelete.next == null) {
        System.out.println("Element not found");
        return;
      }
      nodeToDelete = nodeToDelete.next;
    }
    if (nodeToDelete == head) {
      head = head.next;
    }

    if (nodeToDelete.next != null) {
      nodeToDelete.next.prev = nodeToDelete.prev;
    }
    if (nodeToDelete.prev != null) {
      nodeToDelete.prev.next = nodeToDelete.next;
    }
  }

  public void insertInSortedLL(int data) {
    DLLNode newNode = new DLLNode(data);
    if (head == null) {
      head = newNode;
      return;
    }
    if (head.data > data) {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
      return;
    }
    DLLNode current = head;
    while (current.next != null && current.next.data < data) {
      current = current.next;
    }
    newNode.next = current.next;
    newNode.prev = current;
    if (current.next != null) {
      current.next.prev = newNode;
    }
    current.next = newNode;
  }


  public void printList() {
    DLLNode current = head;
    while (current != null) {
      System.out.printf("%d ", current.data);
      current = current.next;
    }
    System.out.println();
  }

  private void deleteList() {
    head = null;
  }

  public void countTriplets(int x) {
    if (head == null) {
      return;
    }
    int count = 0;
    DLLNode current = head;
    DLLNode first;
    DLLNode last = head;
    while (last.next != null) {
      last = last.next;
    }
    System.out.print("Triplets are : ");
    while (current != null) {
      first = current.next;
      count += countPairs(first, last, x - current.data, current.data);
      current = current.next;
    }
    System.out.println();
    System.out.printf("Triplets count for %d : %d%n", x, count);
  }

  public int countPairs(DLLNode first, DLLNode second, int sum, int currentData) {
    int count = 0;
    while (first != null && second != null && first != second && second.next != first) {
      int x = first.data + second.data;
      if (x == sum) {
        System.out.printf("(%d,%d,%d) ", currentData, first.data, second.data);
        count++;
        first = first.next;
        second = second.prev;
      } else if (x > sum) {
        second = second.prev;
      } else {
        first = first.next;
      }
    }
    return count;
  }

  static class DLLNode {

    DLLNode prev;
    int data;
    DLLNode next;

    public DLLNode(int data) {
      this.data = data;
    }
  }


}
