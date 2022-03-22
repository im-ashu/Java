package com.hackerrank.linkedlists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertingANodeIntoASortedDoublyLinkedList {

  private static final Scanner scanner = new Scanner(System.in);

  public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep,
      BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }

  /*
   * For your reference:
   *
   * DoublyLinkedListNode {
   *     int data;
   *     DoublyLinkedListNode next;
   *     DoublyLinkedListNode prev;
   * }
   *
   */
  static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    if (head == null) {
      newNode.next = null;
      newNode.prev = null;
      head = newNode;
      return head;
    }
    if (head.data > data) {
      newNode.next = head;
      newNode.prev = null;
      head.prev = newNode;
      head = newNode;
      return head;
    }
    DoublyLinkedListNode ptr = head;
    while (ptr.next != null && ptr.next.data < data) {
      ptr = ptr.next;
    }
    newNode.prev = ptr;
    newNode.next = ptr.next;
    ptr.next = newNode;
    return head;
  }

  // Complete the sortedInsert function below.

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("InsertingANodeIntoASortedDoublyLinkedList.txt"));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      DoublyLinkedList llist = new DoublyLinkedList();

      int llistCount = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist.insertNode(llistItem);
      }

      int data = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

      printDoublyLinkedList(llist1, " ", bufferedWriter);
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }

  static class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {

    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
        node.prev = this.tail;
      }

      this.tail = node;
    }
  }
}
