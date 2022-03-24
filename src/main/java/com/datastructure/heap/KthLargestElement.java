package com.datastructure.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

  public static void main(String[] args) {
    int[] array = {12, 3, 5, 7, 19, 5};
    // array = new int[]{12, 13, 12, 13, 11};
    int n = array.length;
    int k = 3;
    System.out.println(kthLargest(array, n, k));
  }

  private static int kthLargest(int[] array, int n, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for (int i = 0; i < k; i++) {
      minHeap.add(array[i]);
    }
    for (int i = k; i < n; i++) {
      if (!minHeap.isEmpty() && minHeap.peek() < array[i]) {
        minHeap.poll();
        minHeap.add(array[i]);
      }
    }
    return !minHeap.isEmpty() ? minHeap.peek() : -1;
  }
}