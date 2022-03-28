package com.leetcode;

import static com.datastructure.linkedlist.singly.LinkedListUtil.deserialize;

import com.datastructure.linkedlist.singly.ListNode;

public class RemoveNthFromEnd {


  public static void main(String[] args) {
    int[] list = {1, 2};
    ListNode head = deserialize(list);
    int n = 2;
    head = new RemoveNthFromEnd().removeNthFromEnd(head, n);
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;
    int count = 1;
    while (fast != null && count < n) {
      fast = fast.next;
      count++;
    }
    while (fast != null && fast.next != null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
    }
    if (prev == null) {
      assert head != null;
      return head.next;
    } else {
      prev.next = slow.next;
      slow.next = null;
      slow = null;
    }
    return head;
  }


}
