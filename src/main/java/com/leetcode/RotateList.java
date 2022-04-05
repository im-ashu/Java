package com.leetcode;

public class RotateList {

  public static void main(String[] args) {
    RotateList rotateList = new RotateList();
    int[] h = {1, 2, 3, 4, 5};
    int k = 2;
    ListNode head = LinkedListUtil.deserialize(h);
    ListNode temp = rotateList.rotateRight(head, k);
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode temp = head;
    int length = 1;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }
    temp.next = head;
    int invK = length - k;
    int count = 1;
    temp = head;
    while (count < invK) {
      temp = temp.next;
      count++;
    }
    head = temp.next;
    temp.next = null;
    return head;
  }
}
