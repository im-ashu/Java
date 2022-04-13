package com.leetcode;

public class RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
    int[] nums = {3, 3, 3, 3, 3, 3};
    ListNode head = LinkedListUtil.deserialize(nums);
    head = removeDuplicatesFromSortedList.deleteDuplicates(head);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-101);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val) {
        ListNode temp = current.next;
        while (temp.next != null && temp.val == temp.next.val) {
          temp = temp.next;
        }
        current.next = temp.next;
      } else {
        current = current.next;
      }
    }
    return dummy.next;
  }

}
