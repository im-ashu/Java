package com.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

  private final int k;
  private final PriorityQueue<Integer> list;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.list = new PriorityQueue<>(k);
    for (int num : nums) {
      list.add(num);
      if (list.size() > k) {
        list.poll();
      }
    }
  }

  public static void main(String[] args) {
    KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
    System.out.println(k.add(3));
    System.out.println(k.add(5));
    System.out.println(k.add(10));
    System.out.println(k.add(9));
    System.out.println(k.add(4));
  }

  public int add(int val) {
    list.add(val);
    if (list.size() > k) {
      list.poll();
    }
    return list.peek();
  }
}