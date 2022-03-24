package com.gfg;

import java.util.HashSet;

public class RemoveLoop {

  public static Node newNode(int data) {
    Node temp = new Node();
    temp.data = data;
    temp.next = null;
    return temp;
  }

  public static void makeLoop(Node head, int x) {
      if (x == 0) {
          return;
      }
    Node curr = head;
    Node last = head;

    int currentPosition = 1;
    while (currentPosition < x) {
      curr = curr.next;
      currentPosition++;
    }

      while (last.next != null) {
          last = last.next;
      }
    last.next = curr;
  }

  public static boolean detectLoop(Node head) {
    Node hare = head.next;
    Node tortoise = head;
    while (hare != tortoise) {
        if (hare == null || hare.next == null) {
            return false;
        }
      hare = hare.next.next;
      tortoise = tortoise.next;
    }
    return true;
  }

  public static int length(Node head) {
    int ret = 0;
    while (head != null) {
      ret += 1;
      head = head.next;
    }
    return ret;
  }

  public static void main(String[] args) {
    int t = 1;

    while (t-- > 0) {
      int n = 3;

      int num = 1;
      Node head = newNode(num);
      Node tail = head;
      num = 3;
      tail.next = newNode(num);
      tail = tail.next;
      num = 4;
      tail.next = newNode(num);

      int pos = 2;
      makeLoop(head, pos);

      RemoveLoop x = new RemoveLoop();
      x.removeLoop(head);

        if (detectLoop(head) || length(head) != n) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }
  }

  public void removeLoop(Node head) {
    HashSet<Node> s = new HashSet<>();
    Node prev = null;
    Node traverse = head;
    while (traverse != null) {
      if (s.contains(traverse)) {
        prev.next = null;
        break;
      }
      s.add(traverse);
      prev = traverse;
      traverse = traverse.next;
    }
  }

  static class Node {

    int data;
    Node next;
  }
}