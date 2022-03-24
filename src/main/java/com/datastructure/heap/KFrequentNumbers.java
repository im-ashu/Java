package com.datastructure.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KFrequentNumbers {

  public static void main(String[] args) {
    int[] arr = {2, 1, 1, 1, 3, 2, 2, 2, 2, 4};
    int k = 2;
    int n = arr.length;
    kFrequentNumbers(arr, k, n).stream().map(number -> number + " ").forEach(System.out::print);
  }

  private static ArrayList<Integer> kFrequentNumbers(int[] arr, int k, int n) {
    ArrayList<Integer> result = new ArrayList<>(k);
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(frequencyMap::get));
    for (int i = 0; i < n; i++) {
      frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
    }
    for (Integer key : frequencyMap.keySet()) {
      minHeap.add(key);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll());
    }
    return result;
  }
}