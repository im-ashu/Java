package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

  public static void main(String[] args) {
    int[] nums = {1};
    int k = 1;
    int[] topKFrequent = new TopKFrequentElements().topKFrequent(nums, k);
    for (int i : topKFrequent) {
      System.out.print(i + " ");
    }

  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(map::get));
    for (Integer key : map.keySet()) {
      minHeap.add(key);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    int index = 0;
    int[] res = new int[k];
    while (!minHeap.isEmpty()) {
      res[index++] = minHeap.poll();
    }
    return res;
  }
}