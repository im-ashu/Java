package com.leetcode;

public class SwappingNodesInALinkedList {

  public static void main(String[] args) {
    SwappingNodesInALinkedList linkedList = new SwappingNodesInALinkedList();
    int[] nodes = {1, 2, 3, 4, 5};
    ListNode head = LinkedListUtil.deserialize(nodes);
    int k = 5;
    ListNode current = linkedList.swapNodes(head, k);
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }

  }

  public ListNode swapNodes(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode kthNode;
    ListNode kthNodeFromEnd;
    int count = 1;
    ListNode fast = head;
    while (count != k) {
      fast = fast.next;
      count++;
    }
    kthNode = fast;
    kthNodeFromEnd = head;
    while (fast.next != null) {
      fast = fast.next;
      kthNodeFromEnd = kthNodeFromEnd.next;
    }
    int temp = kthNode.val;
    kthNode.val = kthNodeFromEnd.val;
    kthNodeFromEnd.val = temp;
    return head;
  }
}
