package com.leetcode;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, new ListNode(9,
        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    final ListNode result = addTwoNumbers(l1, l2);
    ListNode current = result;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
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

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}