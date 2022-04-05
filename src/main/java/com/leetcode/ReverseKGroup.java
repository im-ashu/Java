package com.leetcode;

public class ReverseKGroup {

  public static void main(String[] args) {
    ReverseKGroup reverseKGroup = new ReverseKGroup();
    int k = 3;
    int[] h = {1, 2, 3, 4, 5};
    ListNode head = LinkedListUtil.deserialize(h);
    ListNode temp = reverseKGroup.reverseKGroup(head, k);
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int count = 0;
    ListNode prev = null;
    ListNode current = head;
    ListNode next;
    while (current != null && count != k) {
      count++;
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    if (count < k) {
      head = prev;
      current = head;
      prev = null;
      while (current != null && count != 0) {
        count--;
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
    }
    if (current != null) {
      head.next = reverseKGroup(current, k);
    }
    return prev;
  }
}
