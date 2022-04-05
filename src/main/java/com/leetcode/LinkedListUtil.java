package com.leetcode;

public class LinkedListUtil {

  public static ListNode deserialize(int[] list) {
    ListNode dummy = new ListNode(0);
    ListNode headNext = dummy;
    for (int j : list) {
      dummy.next = new ListNode(j);
      dummy = dummy.next;
    }
    return headNext.next;
  }

  public static Node deserialize(int[][] h) {
    Node[] nodeArr = new Node[h.length];
    for (int i = 0, hLength = h.length; i < hLength; i++) {
      nodeArr[i] = new Node(h[i][0]);
      if (i > 0) {
        nodeArr[i - 1].next = nodeArr[i];
      }
    }
    for (int i = 0, hLength = h.length; i < hLength; i++) {
      nodeArr[i].random = h[i][1] >= 0 ? nodeArr[h[i][1]] : null;
    }
    return nodeArr[0];
  }
}