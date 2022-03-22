package com.codestudio;

import java.util.ArrayList;
import java.util.List;

public class CountDerangements {

  static long count = 0;
  static long modulo = 1000000007;

  public static void main(String[] args) {
    int n = 3;
    System.out.println(countDerangements(n));
  }

  public static long countDerangements(int n) {
    // Write your code here.
    count = 0;
    permuteUtil(n, new ArrayList<>());
    return count % modulo;
  }

  private static void permuteUtil(int n, List<Integer> subset) {
    if (subset.size() == n) {
      count++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (subset.contains(i) || subset.size() == i) {
        continue;
      }
      subset.add(i);
      permuteUtil(n, subset);
      subset.remove(subset.size() - 1);
    }
  }

}