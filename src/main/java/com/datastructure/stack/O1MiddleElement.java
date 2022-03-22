package com.datastructure.stack;

public class O1MiddleElement {

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(5);
    System.out.println(stack.getMiddle());
    stack.push(9);
    System.out.println(stack.getMiddle());

    stack.pop();
    System.out.println(stack.getMiddle());

  }

  static class DoublyLinkedListNode {

    DoublyLinkedListNode previous;
    int data;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data) {
      this.data = data;
    }
  }

  static class Stack {

    DoublyLinkedListNode head;
    DoublyLinkedListNode mid;
    int count;

    public Stack() {
      count = 0;
    }

    public void push(int newData) {
      DoublyLinkedListNode newEntry = new DoublyLinkedListNode(newData);
      newEntry.previous = null;
      newEntry.next = head;
      count++;
      if (count == 1) {
        mid = newEntry;
      } else {
        head.previous = newEntry;
        if ((count % 2) != 0) {
          mid = mid.previous;
        }
      }
      head = newEntry;
    }

    public int pop() {
      if (count == 0) {
        return Integer.MIN_VALUE;
      }
      int data = head.data;
      count--;
      head = head.next;
      if (head != null) {
        head.previous = null;
      }
      if (count % 2 == 0) {
        mid = mid.next;
      }
      return data;
    }

    public int getMiddle() {
      if (count == 0) {
        return Integer.MIN_VALUE;
      }
      return mid.data;
    }
  }
}
