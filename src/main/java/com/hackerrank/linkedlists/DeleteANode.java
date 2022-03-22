package com.hackerrank.linkedlists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DeleteANode {

  private static final Scanner scanner = new Scanner(System.in);

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep,
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
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */
  static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
    if (position == 0) {
      head = head.next;
      return head;
    }
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode prev = null;
    while (position-- > 0) {
      prev = current;
      current = current.next;
    }
    assert prev != null;
    prev.next = current.next;
    return head;
  }

  // Complete the deleteNode function below.

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("DeleteANode.txt"));

    SinglyLinkedList llist = new SinglyLinkedList();

    int llistCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < llistCount; i++) {
      int llistItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      llist.insertNode(llistItem);
    }

    int position = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

    printSinglyLinkedList(llist1, " ", bufferedWriter);
    bufferedWriter.newLine();

    bufferedWriter.close();

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
