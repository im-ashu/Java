package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxPerformance {

  public static void main(String[] args) {
    MaxPerformance maxPerformance = new MaxPerformance();
    int[] speed = {2,10,3,1,5,8};
    int[] efficiency = {5,4,3,9,7,2};
    int n = efficiency.length;
    int k = 3;
    System.out.println(maxPerformance.maxPerformance(n, speed, efficiency, k));

  }

  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    long[] result = new long[]{0};
    maxPerformance(n, speed, efficiency, k, 0, new ArrayList<>(), result);
    return (int) (result[0] % (1e9 + 7));
  }

  private void maxPerformance(int n, int[] speed, int[] efficiency, int k, int i,
      List<Integer> subset, long[] result) {
    if (i >= n) {
      return;
    }
    if (subset.size() > 0 && subset.size() <= k) {
      long sum = 0;
      long min = Integer.MAX_VALUE;
      for (Integer element : subset) {
        sum += speed[element];
        min = Math.min(min, efficiency[element]);
      }
      result[0] = Math.max(result[0], sum * min);
      return;
    }
    for (int j = i; j < n; j++) {
      subset.add(j);
      maxPerformance(n, speed, efficiency, k, j + 1, subset, result);
      subset.remove(subset.size() - 1);
    }
  }
}
