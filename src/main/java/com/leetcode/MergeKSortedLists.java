package com.leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

  public static void main(String[] args) {
    MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
    ListNode[] lists = {LinkedListUtil.deserialize(new int[]{})};
    ListNode head = mergeKSortedLists.mergeKLists(lists);
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> {
      if (a == null) {
        return 1;
      }
      if (b == null) {
        return -1;
      }
      return Integer.compare(a.val, b.val);
    });
    for (ListNode list : lists) {
      if (list != null) {
        minHeap.add(list);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!minHeap.isEmpty()) {
      ListNode head = minHeap.poll();
      tail.next = head;
      tail = tail.next;
      if (head.next != null) {
        minHeap.add(head.next);
      }
    }
    return dummy.next;
  }
}
