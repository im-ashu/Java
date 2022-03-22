package com.hackerrank.linkedlists;

import java.util.Scanner;

public class PrintTheElementsOfALinkedList {

  private static final Scanner scanner = new Scanner(System.in);

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static void printLinkedList(SinglyLinkedListNode head) {
    SinglyLinkedListNode current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  // Complete the printLinkedList function below.

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();

    int listCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < listCount; i++) {
      int listItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      list.insertNode(listItem);
    }

    printLinkedList(list.head);

    scanner.close();
  }

  static class SinglyLinkedListNode {

    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {

    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }
}
