package com.datastructure.heap;

import java.util.PriorityQueue;

public class ConnectRopesToMinimiseTheCost {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.println(minimumCost(arr));
  }

  private static int minimumCost(int[] arr) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int cost = 0;
    for (int e : arr) {
      minHeap.add(e);
    }
    while (!minHeap.isEmpty()) {
      int first = minHeap.poll();
      int second = minHeap.poll();
      cost = cost + first + second;
      if (!minHeap.isEmpty()) {
        minHeap.add(first + second);
      }
    }
    return cost;
  }
}