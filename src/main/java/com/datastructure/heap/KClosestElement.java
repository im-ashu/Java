package com.datastructure.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KClosestElement {

  public static void main(String[] args) {
    int[] arr = {5, 6, 7, 8, 9};
    int k = 3;
    int x = 7;
    int n = arr.length;
    kClosestElements(arr, k, x, n).forEach(e -> System.out.print(e + " "));
  }

  private static ArrayList<Integer> kClosestElements(int[] arr, int k, int x, int n) {
    ArrayList<Integer> result = new ArrayList<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (a, b) -> (Math.abs(arr[b] - x) - Math.abs(arr[a] - x)));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      maxHeap.add(i);
    }
    for (int i = k; i < n && maxHeap.size() > 0; i++) {
      int absDiff = Math.abs(arr[i] - x);
      if (Math.abs(arr[maxHeap.peek()] - x) > absDiff) {
        maxHeap.poll();
        maxHeap.add(i);
      }
    }
    while (!maxHeap.isEmpty()) {
      minHeap.add(maxHeap.poll());
    }
    while (!minHeap.isEmpty()) {
      result.add(arr[minHeap.poll()]);
    }
    return result;
  }
}