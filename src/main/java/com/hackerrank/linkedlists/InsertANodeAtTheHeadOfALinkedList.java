package com.hackerrank.linkedlists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertANodeAtTheHeadOfALinkedList {

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
  static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode list, int data) {
    SinglyLinkedListNode head = new SinglyLinkedListNode(data);
    head.next = list;
    return head;
  }

  // Complete the insertNodeAtHead function below.

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc.txt"));

    SinglyLinkedList list = new SinglyLinkedList();

    int listCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < listCount; i++) {
      int listItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      SinglyLinkedListNode list_head = insertNodeAtHead(list.head, listItem);

      list.head = list_head;
    }

    printSinglyLinkedList(list.head, "\n", bufferedWriter);
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


  }
}