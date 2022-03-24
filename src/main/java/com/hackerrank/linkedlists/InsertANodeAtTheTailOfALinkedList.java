package com.hackerrank.linkedlists;


import java.io.IOException;
import java.util.Scanner;

public class InsertANodeAtTheTailOfALinkedList {

  private static final Scanner scanner = new Scanner(System.in);

  public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
//    while (node != null) {
//      bufferedWriter.write(String.valueOf(node.data));
//
//      node = node.next;
//
//      if (node != null) {
//        bufferedWriter.write(sep);
//      }
    SinglyLinkedListNode current = node;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
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
  static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    if (head == null) {
      head = node;
    } else {
      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
    return head;
  }

  // Complete the insertNodeAtTail function below.

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(
//        new FileWriter(System.getenv("OUTPUT_PATH")));

    SinglyLinkedList list = new SinglyLinkedList();

    int listCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < listCount; i++) {
      int listItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      list.head = insertNodeAtTail(list.head, listItem);
    }

    printSinglyLinkedList(list.head);
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();

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

    public SinglyLinkedList() {
      this.head = null;
    }
  }
}
