package com.leetcode;

public class RemoveLinkedListElements {

  public static void main(String[] args) {
    RemoveLinkedListElements listElements = new RemoveLinkedListElements();
    int[] nums = {7, 6, 7, 7};
    ListNode head = LinkedListUtil.deserialize(nums);
    int val = 7;
    head = listElements.removeElements(head, val);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    while (head != null && head.val == val) {
      head = head.next;
    }
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.next.val == val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }
}

