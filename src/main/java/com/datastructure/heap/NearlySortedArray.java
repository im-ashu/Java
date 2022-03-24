package com.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {

  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 2, 8, 10, 9, 11};
    int k = 3;
    int n = arr.length;
    Arrays.stream(nearlySortedArray(arr, k, n)).forEach(e -> System.out.print(e + " "));
  }

  private static int[] nearlySortedArray(int[] arr, int k, int n) {
    int[] result = new int[n];
    int resultIndex = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for (int i = 0; i < k; i++) {
      minHeap.add(arr[i]);
    }
    for (int i = k; i < n; i++) {
      minHeap.add(arr[i]);
      result[resultIndex] = minHeap.poll();
      resultIndex++;
    }
    while (!minHeap.isEmpty()) {
      result[resultIndex] = minHeap.poll();
      resultIndex++;
    }
    return result;
  }
}