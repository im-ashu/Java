package com.leetcode;


public class AddTwoNumbersII {

  public static void main(String[] args) {
    AddTwoNumbersII add = new AddTwoNumbersII();
    int[] list1 = {7, 2, 4, 3}, list2 = {5, 6, 4};
    ListNode l1 = LinkedListUtil.deserialize(list1);
    ListNode l2 = LinkedListUtil.deserialize(list2);
    ListNode current = add.addTwoNumbers(l1, l2);
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode dummy = new ListNode(0);
    ListNode temp = dummy;
    int sum;
    int carry = 0;
    while (l1 != null && l2 != null) {
      sum = l1.val + l2.val + carry;
      carry = sum / 10;
      temp.next = new ListNode(sum % 10);
      temp = temp.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      sum = l1.val + carry;
      carry = sum / 10;
      temp.next = new ListNode(sum % 10);
      temp = temp.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      sum = l2.val + carry;
      carry = sum / 10;
      temp.next = new ListNode(sum % 10);
      temp = temp.next;
      l2 = l2.next;
    }
    if (carry == 1) {
      temp.next = new ListNode(carry);
    }

    return reverse(dummy.next);
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
