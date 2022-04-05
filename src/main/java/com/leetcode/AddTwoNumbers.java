package com.leetcode;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, new ListNode(9,
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    ListNode result = addTwoNumbers(l1, l2);
    ListNode current = result;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
    result = addTwoNumbersII(l1, l2);
    current = result;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  private static ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode add = dummy;
    int carry = 0;
    int sum = 0;
    while (l1 != null && l2 != null) {
      sum = (carry + l1.val + l2.val) % 10;
      carry = (carry + l1.val + l2.val) / 10;
      dummy.next = new ListNode(sum);
      dummy = dummy.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      sum = (carry + l1.val) % 10;
      carry = (carry + l1.val) / 10;
      dummy.next = new ListNode(sum);
      dummy = dummy.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      sum = (carry + l2.val) % 10;
      carry = (carry + l2.val) / 10;
      dummy.next = new ListNode(sum);
      dummy = dummy.next;
      l2 = l2.next;
    }
    if (carry == 1) {
      dummy.next = new ListNode(carry);
    }
    return add.next;
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode current = null;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int rem = (l1.val + l2.val + carry) % 10;
      carry = (l1.val + l2.val + carry) / 10;
      if (result == null) {
        result = new ListNode(rem);
        current = result;
      } else {
        current.next = new ListNode(rem);
        current = current.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int rem = (l1.val + carry) % 10;
      carry = (l1.val + carry) / 10;
      if (result == null) {
        result = new ListNode(rem);
        current = result;
      } else {
        current.next = new ListNode(rem);
        current = current.next;
      }
      l1 = l1.next;
    }
    while (l2 != null) {
      int rem = (l2.val + carry) % 10;
      carry = (l2.val + carry) / 10;
      if (result == null) {
        result = new ListNode(rem);
        current = result;
      } else {
        current.next = new ListNode(rem);
        current = current.next;
      }
      l2 = l2.next;
    }
    if (carry == 1) {
      current.next = new ListNode(carry);
    }
    return result;
  }
}