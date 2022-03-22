package com.hackerrank.linkedlists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindMergePointOfTwoLists {

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
  static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    int count1 = 1;
    int count2 = 1;
    SinglyLinkedListNode ptr1 = head1;
    SinglyLinkedListNode ptr2 = head2;
    while (ptr1.next != null) {
      count1++;
      ptr1 = ptr1.next;
    }
    while (ptr2.next != null) {
      count2++;
      ptr2 = ptr2.next;
    }
    ptr1 = head1;
    ptr2 = head2;
    if (count1 > count2) {
      int i = count1 - count2;
      while (i-- > 0) {
        ptr1 = ptr1.next;
      }
    } else {
      int i = count2 - count1;
      while (i-- > 0) {
        ptr2 = ptr2.next;
      }
    }
    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return ptr1.data;
  }

  // Complete the findMergeNode function below.

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("FindMergePointOfTwoLists.txt"));

    int tests = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int testsItr = 0; testsItr < tests; testsItr++) {
      int index = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      SinglyLinkedList llist1 = new SinglyLinkedList();

      int llist1Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist1Count; i++) {
        int llist1Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist1.insertNode(llist1Item);
      }

      SinglyLinkedList llist2 = new SinglyLinkedList();

      int llist2Count = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llist2Count; i++) {
        int llist2Item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist2.insertNode(llist2Item);
      }

      SinglyLinkedListNode ptr1 = llist1.head;
      SinglyLinkedListNode ptr2 = llist2.head;

      for (int i = 0; i < llist1Count; i++) {
        if (i < index) {
          ptr1 = ptr1.next;
        }
      }

      for (int i = 0; i < llist2Count; i++) {
        if (i != llist2Count - 1) {
          ptr2 = ptr2.next;
        }
      }

      ptr2.next = ptr1;

      int result = findMergeNode(llist1.head, llist2.head);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

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
