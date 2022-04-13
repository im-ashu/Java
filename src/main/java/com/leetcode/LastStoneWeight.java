package com.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

  public static void main(String[] args) {
    LastStoneWeight lastStoneWeight = new LastStoneWeight();
    int[] stones = {1};
    System.out.println(lastStoneWeight.lastStoneWeight(stones));
  }

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    for (int stone : stones) {
      maxHeap.add(stone);
    }
    while (maxHeap.size() >= 2) {
      int first = maxHeap.poll();
      int second = maxHeap.poll();
      if (first > second) {
        maxHeap.offer(first - second);
      }
    }
    return maxHeap.size() == 1 ? maxHeap.poll() : 0;
  }
}
