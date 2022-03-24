package com.datastructure.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class FrequencySort {

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 3, 2, 2, 4, 2, 2};
    int k = 2;
    int n = arr.length;
    frequencySort(arr, k, n).stream().map(number -> number + " ").forEach(System.out::print);
  }

  private static ArrayList<Integer> frequencySort(int[] arr, int k, int n) {
    ArrayList<Integer> result = new ArrayList<>(n);
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (a, b) -> frequencyMap.get(b).compareTo(frequencyMap.get(a)));
    IntStream.range(0, n)
        .forEach(i -> frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1));
    maxHeap.addAll(frequencyMap.keySet());
    while (!maxHeap.isEmpty()) {
      Integer element = maxHeap.poll();
      int range = frequencyMap.get(element);
      IntStream.range(0, range).mapToObj(i -> element).forEach(result::add);
    }

    return result;
  }
}