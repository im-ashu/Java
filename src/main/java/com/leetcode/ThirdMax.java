package com.leetcode;

import java.util.PriorityQueue;

public class ThirdMax {

  public static void main(String[] args) {
    int[] nums = {2, 2, 3, 1};
    System.out.println(new ThirdMax().thirdMax(nums));
  }

  public int thirdMax(int[] nums) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(nums[0]);
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      if (!priorityQueue.contains(nums[i])) {
        priorityQueue.add(nums[i]);
        if (priorityQueue.size() > 3) {
          priorityQueue.poll();
        }
      }
    }
    if (priorityQueue.size() == 3) {
      return priorityQueue.peek();
    }
    int result = 0;
    while (!priorityQueue.isEmpty()) {
      result = priorityQueue.poll();
    }
    return result;
  }
}
