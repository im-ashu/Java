package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  public static void main(String[] args) {
    CombinationSumIII combinationSumIII = new CombinationSumIII();
    int k = 3;
    int n = 7;
    for (List<Integer> list : combinationSumIII.combinationSum3(k, n)) {
      for (Integer numbers : list) {
        System.out.print(numbers + " ");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    combinationSum3(k, n, res, 1, new ArrayList<>());
    return res;
  }

  public void combinationSum3(int k, int n, List<List<Integer>> res, int number,
      List<Integer> subset) {
    if (subset.size() == k && n == 0) {
      res.add(new ArrayList<>(subset));
    }
    if (subset.size() > k || n < 0) {
      return;
    }

    for (int i = number; i < 10; i++) {
      if (n - i < 0) {
        continue;
      }
      subset.add(i);
      combinationSum3(k, n - i, res, i + 1, subset);
      subset.remove(subset.size() - 1);
    }
  }
}
