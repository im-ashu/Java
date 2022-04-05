package com.leetcode;

public class CopyRandomList {

  public static void main(String[] args) {
    CopyRandomList copyRandomList = new CopyRandomList();
    int[][] h = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
    Node head = LinkedListUtil.deserialize(h);
    Node node = copyRandomList.copyRandomList(head);
    while (node != null) {
      System.out.print(
          "( " + node.val + "," + (node.random != null ? node.random.val : null) + " )");
      node = node.next;
    }
  }

  public Node copyRandomList(Node head) {
    Node temp = head;
    while (temp != null) {
      Node next = temp.next;
      temp.next = new Node(temp.val);
      temp.next.next = next;
      temp = next;
    }
    temp = head;
    while (temp != null) {
      if (temp.random != null) {
        temp.next.random = temp.random.next;
      }
      temp = temp.next.next;
    }
    temp = head;
    Node dummy = new Node(0);
    Node h = dummy;
    while (temp != null && temp.next != null) {
      h.next = temp.next;
      temp.next = temp.next.next;
      temp = temp.next;
      h = h.next;
    }
    return dummy.next;
  }
}
