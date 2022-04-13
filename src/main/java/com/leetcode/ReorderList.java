package com.leetcode;

public class ReorderList {

  public static void main(String[] args) {
    ReorderList reorderList = new ReorderList();
    int[] nums = {1, 2, 3, 4};
    ListNode head = LinkedListUtil.deserialize(nums);
    reorderList.reorderList(head);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode revListHead = slow.next;
    slow.next = null;
    revListHead = reverse(revListHead);
    slow = head;
    ListNode next;
    ListNode revNext;
    while (slow != null && revListHead != null) {
      next = slow.next;
      revNext = revListHead.next;
      slow.next = revListHead;
      revListHead.next = next;
      revListHead = revNext;
      slow = next;
    }
  }

  private ListNode reverse(ListNode head) {
    ListNode current = head;
    ListNode prev = null;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
