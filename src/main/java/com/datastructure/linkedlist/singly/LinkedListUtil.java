package com.datastructure.linkedlist.singly;


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
}
