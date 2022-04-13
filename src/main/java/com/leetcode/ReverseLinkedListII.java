package com.leetcode;

public class ReverseLinkedListII {

  public static void main(String[] args) {
    ReverseLinkedListII reverseLinkedList = new ReverseLinkedListII();
    int[] nums = {1, 2, 3, 4, 5};
    ListNode head = LinkedListUtil.deserialize(nums);
    int left = 5;
    int right = 5;
    head = reverseLinkedList.reverseBetween(head, left, right);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }
    ListNode leftPrev = null;
    ListNode rightNext;
    ListNode leftNode = null;
    int n = 1;
    ListNode temp = head;
    while (n != right) {
      if (n + 1 == left) {
        leftPrev = temp;
      } else if (n == left) {
        leftNode = temp;
      }
      n++;
      temp = temp.next;
    }
    rightNext = temp.next;
    if (leftPrev == null) {
      return reverse(leftNode, right - left + 1, rightNext);
    } else {
      leftPrev.next = reverse(leftNode, right - left + 1, rightNext);
    }
    return head;
  }

  private ListNode reverse(ListNode leftNode, int count, ListNode prev) {
    ListNode current = leftNode;
    ListNode next;
    while (count-- > 0) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}
