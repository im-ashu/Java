package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  public static void main(String[] args) {
    Combinations combinations = new Combinations();
    int n = 4;
    int k = 3;
    List<List<Integer>> result = combinations.combine(n, k);
    for (List<Integer> integers : result) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    combine(n, k, 1, new ArrayList<>(), result);
    return result;
  }

  private void combine(int n, int k, int start, List<Integer> subset, List<List<Integer>> result) {
    if (k == 0) {
      result.add(new ArrayList<>(subset));
      return;
    }
    for (int i = start; i <= n - k + 1; i++) {
      subset.add(i);
      combine(n, k - 1, i + 1, subset, result);
      subset.remove(subset.size() - 1);
    }
  }
}
