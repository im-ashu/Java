package com.datastructure.linkedlist.singly;

import java.util.LinkedList;

public class AddOne {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();

  }

  public static Node addOne(Node head) {
    //code here.
    Node trav = head;
    long number = 0L;
    while (trav != null) {
      number = (number * 10) + (trav.data);
      trav = trav.next;
    }
    number = number + 1;
    head = null;
    while (number != 0) {
      Node temp = new Node((int) (number % 10));
      if (head != null) {
        temp.next = head;
      }
      head = temp;
      number /= 10;
    }
    return head;
  }
}